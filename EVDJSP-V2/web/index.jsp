<%@page import="entity.Emp" %>
<%@page import="dao.EmpDao" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
    List<Emp> list = EmpDao.getAll();
    request.setAttribute("list", list);

%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <a href="addStuForm.jsp"> Add Student</a> 
        <h1>All Student</h1>
        
        <table border="1">
<thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <th>Fee</th>
        <th>Subject</th>
        <th>Action</th>
    </tr>
</thead>
<tbody>
    
    <c:forEach items="${list}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.custom1}</td>
            <td>${s.custom2}</td>
            <td>${s.custom3}</td>
            <td>${s.custom4}</td>
            <td>
                
                <a href="editForm.jsp?id=${s.id}" >Edit</a> 
                <a href="delete.jsp?id=${s.id}" >Delete</a> 
            </td>
            
        </tr>
        
        
    </c:forEach>
</tbody>



</table>



    </body>
</html>
