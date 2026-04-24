<%@page import="model.Student" %>

<%@page import="dao.StudentDao" %>
<%
String id= request.getParameter("id");
Student s= StudentDao.getStudentById(Integer.parseInt(id));

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Student Update Form</h1>
        <form action="updateStudent.jsp" method="post">
            <input type="hidden" name="id" value="<%=s.getId()%>"><br>
            <label>Name:</label>
            <input type="text" name="name" value="<%=s.getName()%>"><br>
            <label>Email:</label>
            <input type="email" name="email"  value="<%=s.getEmail()%>"><br>
            <label>Address:</label>
             <input type="text" name="address"  value="<%=s.getAddress()%>"><br>
            <label>Cell No:</label>
             <input type="text" name="cell"  value="<%=s.getCell()%>"><br>
             <input type="submit" value="save">
            
        </form>
        
    </body>
</html>
