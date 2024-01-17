package servlet;

import model.Category;
import service.CategoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    private final CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryRepository.getALLCategory();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/pages/category.jsp").forward(req, resp);
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("pageName").equals("add"))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            String category = req.getParameter("category");
            float price = Float.parseFloat(req.getParameter("price"));
            categoryRepository.create(id,category,price);
        }
        if(req.getParameter("pageName").equals("delete"))
        {
            int id = Integer.parseInt(req.getParameter("id_del"));
            categoryRepository.delete(id);
        }

        this.doGet(req, resp);
    }
}
