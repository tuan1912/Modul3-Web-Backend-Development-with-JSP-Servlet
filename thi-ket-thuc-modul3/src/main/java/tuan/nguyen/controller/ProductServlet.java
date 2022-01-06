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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Product Servlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(req,resp);
                    break;
                case "edit":
                    updateProduct(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isDelete = productDAO.deleteProduct(id);
        System.out.println(isDelete);
        List<Product> products = productDAO.selectAllProducts();
        req.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/list.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Product changeProduct = new Product(id,name, price, quantity,color,description,categoryId);
        productDAO.updateProduct(changeProduct);
        List<Product> products ;
        products = productDAO.selectAllProducts();
        req.setAttribute("products",products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(req, resp);

    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Product newProduct = new Product(name, price, quantity,color,description,categoryId);
        productDAO.insertProduct(newProduct);
        List<Product> products ;
        products = productDAO.selectAllProducts();
        req.setAttribute("products",products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action" );
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    showCreatePage(req,resp);
                    break;
                case "delete":
                    deleteProduct(req,resp);
                    break;
                case "edit":
                    showEditPage(req,resp);
                    break;
                default:
                    showListPage(req,resp);
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/edit.jsp");
        int idEdit = Integer.parseInt(req.getParameter("id"));
        Product product = productDAO.selectProduct(idEdit);
        List<Category> categories = categoryDAO.selectAllCategory();
        req.setAttribute("categories",categories);
        req.setAttribute("product",product);
        requestDispatcher.forward(req,resp);
    }


    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/create.jsp");
        List<Category> categories = categoryDAO.selectAllCategory();
        req.setAttribute("categories",categories);
        requestDispatcher.forward(req,resp);
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
        for (int i = 0; i < products.size(); i++) {
            Category category = categoryDAO.selectCategory(products.get(i).getCategoryId());
            categories.add(category);
        }
        return categories;
    }

}
