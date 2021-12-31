package tuan.nguyen.controller;

import tuan.nguyen.model.Product;
import tuan.nguyen.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action" );
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                showDeleteForm(req,resp);
                break;
            default:
                showListPage(req,resp);
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher  = req.getRequestDispatcher("product/delete.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Product deleteProduct = productService.findById(id);
        req.setAttribute("deleteProduct",deleteProduct);
        requestDispatcher.forward(req,resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Product changeProduct = productService.findById(id);
        req.setAttribute("changeProduct",changeProduct);
        requestDispatcher.forward(req,resp);

    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showListPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/list.jsp");
        List<Product> products = productService.findAll();
        req.setAttribute("products",products);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action" );
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                creatProduct(req,resp);
                break;
            case "edit":
                editProduct(req,resp);
                break;
            case "delete":
                removeProduct(req, resp);
                break;
        }
    }

    private void removeProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int indexOfId = productService.getIndexByProductId(id);
        productService.delete(indexOfId);
        resp.sendRedirect("/product");
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int indexOfId = productService.getIndexByProductId(id);
        productService.update(indexOfId,new Product(id,name,price));
        resp.sendRedirect("/product");
    }

    private void creatProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        productService.save(new Product(id,name,price));
        resp.sendRedirect("/product");
    }


}
