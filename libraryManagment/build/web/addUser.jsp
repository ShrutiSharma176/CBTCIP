<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Dto.User" %>
<%@page import="Dao.UserDao" %>

<jsp:useBean id="obj" class="Dto.User"></jsp:useBean>
<jsp:setProperty name="obj" property="*" ></jsp:setProperty>

<%
    UserDao dao = new UserDao();
    int i = dao.addUser(obj);
    
    if(i>0){
%>
<script>alert("User added successfully");</script>
<%
    }else{
%>
<script>alert("Somethimg went wrong while adding user ");</script>
<%
}
%>
<jsp:include page="addUser.html"></jsp:include>
