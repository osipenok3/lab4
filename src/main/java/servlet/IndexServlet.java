package servlet;

import model.Place;
import service.PlacesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private final PlacesRepository placesRepository = new PlacesRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Place> places = placesRepository.getALLPlaces();
        req.setAttribute("places", places);
        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("pageName").equals("add"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            int row = Integer.parseInt(req.getParameter("row"));
            int place = Integer.parseInt(req.getParameter("place"));
            int category = Integer.parseInt(req.getParameter("category"));
            int id_hall = Integer.parseInt(req.getParameter("id_hall"));
            placesRepository.create(id,row,place,category,id_hall);
        }
        if(req.getParameter("pageName").equals("delete"))
        {
            int id = Integer.parseInt(req.getParameter("id_del"));
            placesRepository.delete(id);
        }

        this.doGet(req, resp);
    }


}
