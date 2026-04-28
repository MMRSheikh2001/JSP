/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Student;

/**
 *
 * @author Admin
 */
@WebServlet("/stuservlet")
public class StuServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equalsIgnoreCase(action)) {
            Student s = new Student();
            s.setName(req.getParameter("name"));
            s.setEmail(req.getParameter("email"));
            s.setDob(req.getParameter("dob"));
            s.setFee(Double.parseDouble(req.getParameter("fee")));
            StudentDao.save(s);
            resp.sendRedirect("home.jsp");
            
        } else if ("update".equalsIgnoreCase(action)) {
            Student s = new Student();
            s.setName(req.getParameter("name"));
            s.setEmail(req.getParameter("email"));
            s.setDob(req.getParameter("dob"));
            s.setFee(Double.parseDouble(req.getParameter("fee")));
            s.setId(Integer.parseInt(req.getParameter("id")));
            
            StudentDao.update(s);
            resp.sendRedirect("home.jsp");
            
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            StudentDao.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("home.jsp");
            
        } else if ("edit".equalsIgnoreCase(action)) {
            Student s = StudentDao.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("stu", s);
            req.getRequestDispatcher("editStu.jsp").forward(req, resp);
            
        }
        
    }
    
}
