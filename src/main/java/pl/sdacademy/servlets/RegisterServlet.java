package pl.sdacademy.servlets;

import pl.sdacademy.utils.DatabaseFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DatabaseFunction databaseFunction = new DatabaseFunction();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        if (databaseFunction.checkForLogin(login)){
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite://d:users.db");
                String addQuery = "INSERT INTO users VALUES (?,?)";
                preparedStatement = connection.prepareStatement(addQuery);
                preparedStatement.setString(1,login);
                preparedStatement.setString(2,password);
                preparedStatement.executeUpdate();
                response.sendRedirect("login.jsp");

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            request.setAttribute("invalidUser","Login already in use!!!");
            request.getRequestDispatcher("register.jsp")
                    .forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}