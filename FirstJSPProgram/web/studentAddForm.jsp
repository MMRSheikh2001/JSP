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
        <h1>Student Form</h1>
        <form action="saveStudent.jsp" method="post">
            <label>Name:</label>
            <input type="text" name="name"><br>
            <label>Email:</label>
            <input type="email" name="email"><br>
            <label>Address:</label>
             <input type="text" name="address"><br>
            <label>Cell No:</label>
             <input type="text" name="cell"><br>
             <input type="submit" value="save">
            
        </form>
        
    </body>
</html>
