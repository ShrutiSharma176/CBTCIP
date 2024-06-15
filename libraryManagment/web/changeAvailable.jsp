<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dao.AdminDao" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    AdminDao dao = new AdminDao();
    int i = dao.changeAvailabilty(id);
     if(i>0){
%>
<script>alert("Book availability changed successfully");</script>
<jsp:include page="showBook.jsp"></jsp:include>
<%
    }else{
%>
<script>alert("Something went wrong while changing availability");</script>
<jsp:include page="showBook.jsp"></jsp:include>
<%
}
%>