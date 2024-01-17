package servlet;

import model.Hall;
import service.HallRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hall")
public class HallServlet extends HttpServlet {
    private final HallRepository hallRepository = new HallRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hall> halls = hallRepository.getALLHall();
        req.setAttribute("halls", halls);
        req.getRequestDispatcher("/pages/hall.jsp").forward(req, resp);
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("pageName").equals("add"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            hallRepository.create(id,name);
        }
        if(req.getParameter("pageName").equals("delete"))
        {
            int id = Integer.parseInt(req.getParameter("id_del"));
            hallRepository.delete(id);
        }
        this.doGet(req, resp);
    }

}
