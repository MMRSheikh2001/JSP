<%-- 
    Document   : index
    Created on : May 1, 2026, 3:04:05 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="entity.Custom" %>
<%@page import="dao.CustomDao" %>
<%@page import="java.util.List" %>
<%
List<Custom> cList= CustomDao.viewAll();
request.setAttribute("list",cList);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1><a href="add.jsp">Add Student</a></h1>
        <br><br>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Date Of Birth</th>
                    <th>Fee</th>
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
                        <td>
                            <a href="customservlet?action=edit&id=${s.getId()}">Edit</a>
                            <a href="customservlet?action=delete&id=${s.getId()}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
