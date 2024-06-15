<%@page import="java.sql.*" %>
<%@page import="Dao.UserDao" %>
<%@page import="Dto.User" %>

<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    UserDao dao = new UserDao();
    int i = dao.searchUser(email, password);
    if(i>0){
        session = request.getSession();
        session.setAttribute("email", email);
        RequestDispatcher rd = request.getRequestDispatcher("userHomePage.jsp");
        rd.forward(request,response);
    }else{
        response.sendRedirect("userLogin.html");
    }
    
%>