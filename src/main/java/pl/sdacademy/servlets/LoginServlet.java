package pl.sdacademy.servlets;

import pl.sdacademy.model.User;
import pl.sdacademy.utils.DatabaseFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DatabaseFunction databaseFunction =  new DatabaseFunction();
        User user = databaseFunction.getUser(login);


        if(login.equals(user.getLogin())&&password.equals(user.getPassword())){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(15);
            session.setAttribute("login",login);
            response.sendRedirect("index.jsp");

        }
        else {
            request.setAttribute("loginError","error");
            request.getRequestDispatcher("login.jsp")
                    .forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
