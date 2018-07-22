package pl.sdacademy.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "AddPersonServlet", value = "/add_person")
public class AddPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        int bornYear = Integer.parseInt(request.getParameter("bornYear"));
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String sex = request.getParameter("sex");

        try {
            Class.forName("org.sqlite.JDBC"); //inicjalizacja sterownika
            Connection connection = DriverManager.getConnection("jdbc:sqlite://d:peopleDB.db");

            String addQuery = "INSERT INTO people VALUES(?,?,?,?,?)";

            PreparedStatement insertStatement = connection.prepareStatement(addQuery);

            insertStatement.setString(1,name);
            insertStatement.setString(2,lastName);
            insertStatement.setInt(3,bornYear);
            insertStatement.setInt(4,phoneNumber);
            insertStatement.setString(5,sex);

            insertStatement.executeUpdate();

            insertStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("add_person.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add_person.jsp")
                .forward(request, response);
    }
}
