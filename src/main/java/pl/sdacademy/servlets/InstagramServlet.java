package pl.sdacademy.servlets;

import pl.sdacademy.utils.InstagramDownloader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InstagramServlet", value = "/instagram")
public class InstagramServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String instagramAccountccount = request.getParameter("instagram_account");
        String numberOfPhotosString = request.getParameter("number_of_photos");
        int numberOfPhotos = Integer.parseInt(numberOfPhotosString);

        System.out.println(instagramAccountccount + "  " + numberOfPhotos);
        InstagramDownloader downloader = new InstagramDownloader();
        List<String> urls = downloader.getUrls(instagramAccountccount, numberOfPhotos);
        for (String urlLink : urls) {
            System.out.println(urlLink);
        }
        HttpSession session = request.getSession();
        session.setAttribute("urls",urls);

//        request.setAttribute("urls", urls);
//        request.getRequestDispatcher("/gallery2")
//        .forward(request,response);

        response.sendRedirect("/gallery2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("instagram.jsp");
    }
}
