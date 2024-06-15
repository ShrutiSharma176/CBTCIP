<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Dao.BookDao" %>
<%@page import="Dto.Book" %>

<jsp:useBean id="obj" class="Dto.Book"></jsp:useBean>
<jsp:setProperty name="obj" property="*"></jsp:setProperty>

<%
    BookDao dao = new BookDao();
    int i = dao.addBook(obj);
    if(i>0){
%>
<script> alert("Book Added Sucessfully "); </script>
<%   
  }else{
%>
<script> alert("Somethimg went wrong while adding book "); </script>
<%   
}
%>
<jsp:include page="addBook.html"></jsp:include>
