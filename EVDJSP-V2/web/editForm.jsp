<%@page import="entity.Emp" %>
<%@page import="dao.EmpDao" %>



<%
    int id = Integer.parseInt(request.getParameter("id"));    
    Emp e = EmpDao.getById(id);

%>




<form action="edit.jsp" method="post">
    
    <input type="hidden" name ="id" value="<%=e.getId()%>" />
    <label for="">Name</label>
    <input type="text" name="name" value="<%=e.getName()%>" > <br>
    <label for="">Email</label>
    <input type="email" name="custom1" value="<%=e.getCustom1()%>" > <br>
    <label for="">Date of Birth</label>
    <input type="date" name="custom2" value="<%=e.getCustom2()%>" > <br>
    <label for="">Fee</label>
    <input type="text" name="custom3" value="<%=e.getCustom3()%>"> <br>
    
     <label for="">Subject</label>
    <select name="custom4" >
         <option selected>Select Anyone</option>
        <option value="JEE" <%= "JEE".equals(e.getCustom4()) ? "selected" : "" %>>JEE</option>
        
        <option value="DDD" <%= "DDD".equals(e.getCustom4()) ? "selected" : "" %>>DDD</option>
       <option value="NT" <%= "NT".equals(e.getCustom4()) ? "selected" : "" %>>NT</option>
        
    </select>
    
    <input type="submit" value="Save">



</form>