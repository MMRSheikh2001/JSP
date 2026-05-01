<%-- 
    Document   : add
    Created on : May 1, 2026, 9:25:40 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <h1>Add Student Form</h1><br><br>
        <form action="customservlet" method="post">
            <input type="hidden" name="action" value="save">
            <label for="name">
                Name
            </label>
            <input type="text" name="name"><br>
            <label for="custom1">
                Email
            </label>
            <input type="email" name="custom1"><br>
            <label for="custom2">Date Of Birth</label>
            <input type="date" name="custom2"><br>
            <label for="custom3" >Fee</label>
            <input type="number" name="custom3"><br><br>
            <input type="submit" value="save">
        </form>
    </body>
</html>
