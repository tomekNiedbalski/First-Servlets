package pl.sdacademy.servlets;

import pl.sdacademy.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AboutServlet", value = "/about")
public class AboutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> personList = new Person().createPersonList();
        request.setAttribute("personList", personList);
        request.getRequestDispatcher("about.jsp")
                .forward(request,response);
    }
}
