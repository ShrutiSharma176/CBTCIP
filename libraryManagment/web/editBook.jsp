<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dto.Book"%>
<%@page import="Dao.BookDao"%>

<jsp:useBean id="obj" class="Dto.Book"></jsp:useBean>
<jsp:setProperty name="obj" property="*"></jsp:setProperty>

<%
//    System.out.println(obj.getId()+" "+obj.getTitle()+" "+obj.getAuthor()+" "+obj.getCategory());
    BookDao dao = new BookDao();
    int i = dao.updateBook(obj);
if(i>0){
%>
<script> alert("Book Updated Sucessfully "); </script>
<jsp:include page="showBook.jsp"></jsp:include>
<%   
  }else{
%>
<script> alert("Somethimg went wrong while updating book "); </script>
<%   
}
%>
<jsp:include page="showBook.jsp"></jsp:include>
