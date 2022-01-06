package tuan.nguyen.controller;

import tuan.nguyen.dao.CategoryDAOImpl;
import tuan.nguyen.dao.ProductDAOImpl;
import tuan.nguyen.model.Category;
import tuan.nguyen.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Product Servlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action" );
        if (action == null){
            action = "";
        }
        switch (action){

            default:
                showListPage(req,resp);
        }
    }

    private void showListPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/list.jsp");
        List<Product> products = productDAO.selectAllProducts();
        List<Category> categories = findCategories(products);
        req.setAttribute("products",products);
        req.setAttribute("categories",categories);
        requestDispatcher.forward(req,resp);
    }
    List<Category> findCategories (List<Product> products){
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < products.size()-1; i++) {
            Category category = categoryDAO.selectCategory(products.get(i).getCategoryId());
            categories.add(category);
        }
        return categories;
    }

}
