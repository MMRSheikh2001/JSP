<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Student" %>

<%@page import="dao.StudentDao" %>
<%@page import="java.util.*" %>
<%

List<Student> list = StudentDao.viewAllStudent();
request.setAttribute("list",list);
%>

<table border="1">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Cell No</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="s" items="${list}">
            <tr>
                <td>${s.getId()}</td>
                <td>${s.getName()}</td>
                <td>${s.getEmail()}</td>
                <td>${s.getAddress()}</td>
                <td>${s.getCell()}</td>
                <td>
                    <a href="updateStudentForm.jsp?id=${s.getId()}" target="target">Edit</a>
                    <a href="deleteStudent.jsp?id=${s.getId()}" target="target">Delete</a>
                </td>
            </tr>      
        </c:forEach>


    </tbody>
</table>
