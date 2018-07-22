package pl.sdacademy.servlets;

import pl.sdacademy.model.Museum;
import pl.sdacademy.utils.DatabaseFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MuseumServlet", value = "/searchMuseum")
public class MuseumServlet extends HttpServlet {

    private DatabaseFunction databaseFunction = new DatabaseFunction();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchParameter = request.getParameter("searchParameter");
        String searchParameter2 = request.getParameter("searchParameter2");
        String searchString = request.getParameter("searchString");
        String searchString2 = request.getParameter("searchString2");

        List<Museum> museums = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite://d:museums.db");
            String addingQuery = "SELECT * FROM museums WHERE "+searchParameter+
                    " LIKE '%"+searchString+"%' AND " + searchParameter2 + " LIKE '%"+searchString2+"%'";
            PreparedStatement selectStatement = connection.prepareStatement(addingQuery);

            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()){
                Museum museum = new Museum(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11));
                museums.add(museum);
            }

            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        request.setAttribute("searchResult", museums);
        request.getRequestDispatcher("searchMuseum.jsp")
                .forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("museums",databaseFunction.getMuseums());

        request.getRequestDispatcher("searchMuseum.jsp")
        .forward(request,response);
    }
}
