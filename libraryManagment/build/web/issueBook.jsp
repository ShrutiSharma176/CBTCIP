<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dto.*" %>
<%@page import="Dao.*" %>

<%
    String email = (String)session.getAttribute("email");
    UserDao userdao = new UserDao();
    User userdto = userdao.getUserDetail(email);
    
    int bookId = Integer.parseInt(request.getParameter("id"));
    IssuedBookDao iDao = new IssuedBookDao();
    int i= iDao.getIssuedBook(bookId, userdto.getId());
//    System.out.println(i);----0
    if(i==0){
        int j=iDao.isAllottedToOther(bookId);
        if(j>0){
%>
<script>alert("Book is already issued ");</script>
<jsp:include page="viewBook.jsp"></jsp:include>
<%
        }else{
            j=iDao.issueBook(bookId, userdto.getId());
            if(j>0){
%>
<script>alert("Book issued successfully");</script>
<jsp:include page="viewBook.jsp"></jsp:include>
<%
            }else{
%>
<script>alert("Something went wrong while issuing book");</script>
<jsp:include page="viewBook.jsp"></jsp:include>
<%
            }
        }
    }else{
        i = iDao.isNotIssued(bookId, userdto.getId());
        if(i>0){
            int j=iDao.updateIssuedBook(bookId, userdto.getId());
            if(j>0){
%>
<script>alert("Book issued successfully");</script>
<jsp:include page="viewBook.jsp"></jsp:include>
<%
            }else{
%>
<script>alert("Something went wrong while issuing book");</script>
<jsp:include page="viewBook.jsp"></jsp:include>
<%
            }

        }
    }
%>