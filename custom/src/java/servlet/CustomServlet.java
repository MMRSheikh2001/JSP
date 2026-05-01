/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.CustomDao;
import entity.Custom;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
@WebServlet("customservlet")
public class CustomServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("save".equalsIgnoreCase(action)) {
            Custom c = new Custom();
            c.setName(req.getParameter("name"));
            c.setCustom1(req.getParameter("custom1"));
            c.setCustom2(req.getParameter("custom2"));
            c.setCustom3(req.getParameter("custom3"));
            c.setCustom4(req.getParameter("custom4"));
            c.setCustom5(req.getParameter("custom5"));
            CustomDao.save(c);
            resp.sendRedirect("index.jsp");
            
        } else if ("update".equalsIgnoreCase(action)) {
            Custom c = new Custom();
            c.setName(req.getParameter("name"));
            c.setCustom1(req.getParameter("custom1"));
            c.setCustom2(req.getParameter("custom2"));
            c.setCustom3(req.getParameter("custom3"));
            c.setCustom4(req.getParameter("custom4"));
            c.setCustom5(req.getParameter("custom5"));
            c.setId(Integer.parseInt(req.getParameter("id")));
            CustomDao.update(c);
            resp.sendRedirect("index.jsp");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            CustomDao.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("index.jsp");
        } else if ("edit".equalsIgnoreCase(action)) {
            Custom c = CustomDao.getById(Integer.parseInt("id"));
            req.setAttribute("cus", c);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        }
    }
    
}
