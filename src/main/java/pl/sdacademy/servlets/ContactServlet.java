package pl.sdacademy.servlets;

import pl.sdacademy.utils.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContactServlet", value = "/contact")
public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String message = request.getParameter("message");

        message = message.replace("\n","<br>");

        EmailSender emailSender = new EmailSender();
        if (!emailSender.sendEmail(email,title,message)) {
            response.sendRedirect("email_sending_error.jsp");
//            request.getRequestDispatcher("email_sending_error.jsp")
//                    .forward(request,response);
        }else {

            request.setAttribute("name", name);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("message", message);
            request.setAttribute("title", title);
            request.getRequestDispatcher("sendMessage.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("contact.jsp")
                .forward(request,response);
    }
}
