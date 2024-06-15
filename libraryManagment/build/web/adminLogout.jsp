<%    
        session.setAttribute("email", null);
        RequestDispatcher rd = request.getRequestDispatcher("adminLogin.html");
        session.invalidate();
        rd.forward(request, response);
%>
