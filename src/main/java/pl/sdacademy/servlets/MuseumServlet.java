package pl.sdacademy.servlets;

import pl.sdacademy.model.Museum;
import pl.sdacademy.utils.DatabaseFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MuseumServlet", value = "/searchMuseum")
public class MuseumServlet extends HttpServlet {

    private DatabaseFunction databaseFunction = new DatabaseFunction();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchParameter = request.getParameter("searchParameter");
        String searchString = request.getParameter("searchString");

        List<Museum> museums = databaseFunction.getMuseums();
        List<Museum> updatedList = new ArrayList<>();

        for (Museum museum : museums) {
            switch (searchParameter){
                case "name":
                    if(museum.getName().contains(searchString)){
                        updatedList.add(museum);
                    }
                    break;
                case "city":
                    if(museum.getCity().contains(searchString)){
                        updatedList.add(museum);
                    }
                    break;
                case "street":
                    if(museum.getStreet().contains(searchString)){
                        updatedList.add(museum);
                    }
                    break;
                case "foundator":
                    if(museum.getMuseumFoundator().contains(searchString)){
                        updatedList.add(museum);
                    }
                    break;
            }
        }
        request.setAttribute("searchResult", updatedList);
        request.getRequestDispatcher("searchMuseum.jsp")
                .forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("museums",databaseFunction.getMuseums());

        request.getRequestDispatcher("searchMuseum.jsp")
        .forward(request,response);
    }
}
