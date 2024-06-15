<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dao.UserDao" %>
<%@page import="Dto.User" %>

<%
    String email = (String)session.getAttribute("email");
    String password = request.getParameter("password");
    String cPassword = request.getParameter("cPassword");
    
    if(password.equals(cPassword)){
        UserDao dao = new UserDao();
        int i = dao.updatePassword(email, password);
        if(i>0){
%>
<script>alert("Password Changed Successfully");</script>
<jsp:include page="userHomePage.jsp"></jsp:include>
<%
        }else{
%>
<script>alert("Something went wrong while updating password");</script>
<jsp:include page="updatePassword.jsp"></jsp:include>
<%
        }
    }else{
%>
<script>alert("Password and Confirm Password doesn't macthed");</script>
<jsp:include page="updatePassword.jsp"></jsp:include>
<%
    }
%>