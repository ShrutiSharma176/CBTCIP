<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dao.AdminDao" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    AdminDao dao = new AdminDao();
    int i = dao.deleteUSer(id);
    
    if(i>0){
%>
<script>alert("User deleted successfully");</script>
<jsp:include page="showUser.jsp"></jsp:include>
<%
    }else{
%>
<script>alert("Something went wrong while deleting User");</script>
<jsp:include page="showUser.jsp"></jsp:include>
<%
}
%>
