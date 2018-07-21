package pl.sdacademy.servlets;

import pl.sdacademy.model.Person;
import pl.sdacademy.utils.DatabaseFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowPersonsServlet", value = "/showPersons")
public class ShowPersonsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseFunction databaseFunction = new DatabaseFunction();
        List<Person> persons = databaseFunction.getPersons();
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("showPersons.jsp")
        .forward(request,response);
    }
}
