<%    
        session.setAttribute("email", null);
        RequestDispatcher rd = request.getRequestDispatcher("userLogin.html");
        session.invalidate();
        rd.forward(request, response);
%>
