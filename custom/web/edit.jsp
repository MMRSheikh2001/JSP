<%-- 
    Document   : edit
    Created on : May 1, 2026, 9:25:52 PM
    Author     : Administrator
--%>
<%@page import="entity.Custom" %>
<%
Custom c= (Custom)request.getAttribute("custom");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Edit Form</title>
    </head>
    <body>
        <h1>Student Edit Form</h1><br><br>
        <form action="customservlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%=c.getId()%>">   
            <label for="name">
                Name 
            </label>
            <input type="text" name="name" value="<%=c.getName()%>"><br>
            <label for="custom1">
                Email
            </label>
            <input type="email" name="custom1" value="<%=c.getCustom1()%>"><br>
            <label for="custom2">Date Of Birth</label>
            <input type="date" name="custom2"  value="<%=c.getCustom2()%>"><br>
            <label for="custom3" >Fee</label>
            <input type="number" name="custom3"  value="<%=c.getCustom3()%>"><br><br>
            <input type="submit" value="update">
        </form>
    </body>
</html>
