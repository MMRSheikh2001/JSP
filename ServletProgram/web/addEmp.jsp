<%-- 
    Document   : studentAddForm
    Created on : Apr 22, 2026, 12:59:21 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save</title>
    </head>
    <body>
        <h1>Employee Form</h1>
        <form action="empServlet" method="post">
            <input type="hidden" name="action" value="add">

            <label>Name:</label>
            <input type="text" name="name"><br>
            <label>Salary</label>
            <input type="text" name="salary"><br>

            <input type="submit" value="save">

        </form>

    </body>
</html>
