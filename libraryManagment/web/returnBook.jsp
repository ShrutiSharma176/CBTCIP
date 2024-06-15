<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dto.*" %>
<%@page import="Dao.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    IssuedBookDao dao = new IssuedBookDao();
    int i = dao.returnBook(id);
    if(i>0){
%>
<script>alert("Book Returned successfully");</script>
<jsp:include page="showIssuedBook.jsp" ></jsp:include>
<%
    }else{
%>
<script>alert("Something went wrong while changing status of book");</script>
<jsp:include page="showIssuedBook.jsp" ></jsp:include>
<%
}
%>
