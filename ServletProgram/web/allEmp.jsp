<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Employee" %>

<%@page import="dao.EmployeeDao" %>
<%@page import="java.util.*" %>
<%

List<Employee> list = EmployeeDao.findAllEmployee();
request.setAttribute("list",list);
%>

<table border="1">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Salary</th>

            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="s" items="${list}">
            <tr>
                <td>${s.getId()}</td>
                <td>${s.getName()}</td>
                <td>${s.getSalary()}</td>

                <td>
                    <a href="empServlet?action=edit&id=${s.getId()}" target="target">Edit</a>
                    <a href="empServlet?action=delete&id=${s.getId()}" target="target">Delete</a>
                </td>
            </tr>      
        </c:forEach>


    </tbody>
</table>
<br>
<h1><a href="addEmp.jsp">Add Employee</a></h1>
