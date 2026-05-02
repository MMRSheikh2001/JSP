<jsp:useBean class="entity.Emp" id="e"/>
<%@page import="dao.EmpDao" %>
<jsp:setProperty  name="e" property="*" />


<% 
    int r = EmpDao.update(e);
    
    if(r > 0){
        response.sendRedirect("index.jsp");
    
    }else{
    response.sendRedirect("editForm.jsp");
    }
    


%>