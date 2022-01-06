package tuan.nguyen.controller;

import tuan.nguyen.dao.StudentDAOImpl;
import tuan.nguyen.model.Student;

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

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAOImpl studentDAO;
    public void init(){
        studentDAO = new StudentDAOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                default:
                    showStudents(req,resp);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void showStudents(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Student> students;
        students = studentDAO.selectAll();
        req.setAttribute("students",students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/list.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
