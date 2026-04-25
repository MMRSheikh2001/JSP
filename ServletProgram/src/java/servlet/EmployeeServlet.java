/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Employee;

/**
 *
 * @author Administrator
 */
@WebServlet("/empServlet")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            Employee e = new Employee();
            e.setName(req.getParameter("name"));
            e.setSalary(Double.parseDouble(req.getParameter("salary")));

            EmployeeDao.saveEmployee(e);
            resp.sendRedirect("allEmp.jsp");

        } else if ("update".equals(action)) {
            Employee e = new Employee();
            e.setName(req.getParameter("name"));
            e.setSalary(Double.parseDouble(req.getParameter("salary")));
            e.setId(Integer.parseInt(req.getParameter("id")));

            EmployeeDao.updateEmployee(e);
            resp.sendRedirect("allEmp.jsp");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            EmployeeDao.deleteEmployee(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("allEmp.jsp");

        } else if ("edit".equals(action)) {
            Employee e = EmployeeDao.getEmployeeById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("emp", e);
            req.getRequestDispatcher("editEmp.jsp").forward(req, resp);
            //      EmployeeDao.updateEmployee(e);

        }
    }

}
