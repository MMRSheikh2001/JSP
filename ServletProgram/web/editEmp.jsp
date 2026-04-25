<%@page import="model.Employee" %>

<%@page import="dao.EmployeeDao" %>
<%
Employee e = (Employee)request.getAttribute("emp");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <h1>Student Update Form</h1>
        <form action="empServlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%=e.getId()%>"><br>
            <label>Name:</label>
            <input type="text" name="name" value="<%=e.getName()%>"><br>
            <label>Salary</label>
            <input type="text" name="salary"  value="<%=e.getSalary()%>"><br>
            <br>
            <input type="submit" value="save">

        </form>

    </body>
</html>
