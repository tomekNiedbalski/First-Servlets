package pl.sdacademy.servlets;

import pl.sdacademy.utils.GalleryDisplayer;
import pl.sdacademy.utils.ImportLinks;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GalleryServlet2", value = "/gallery2")
public class GalleryServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String showingChoice = request.getParameter("showingChoice");
        List<String> urls = (List<String>)session.getAttribute("urls");
        if(urls == null){
            urls = new ImportLinks().importLinks();
        }

        request.setAttribute("photosToPrint", new GalleryDisplayer().prepareTableData(showingChoice, urls));
        request.getRequestDispatcher("gallery2.jsp")
                .forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> urls = (List<String>)session.getAttribute("urls");
        if(urls == null){
            urls = new ImportLinks().importLinks();
        }
        request.setAttribute("photosToPrint", new GalleryDisplayer().prepareTableData("3", urls));
        request.getRequestDispatcher("gallery2.jsp")
                .forward(request, response);
    }

}
