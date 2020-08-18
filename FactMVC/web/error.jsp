<%-- 
    Document   : error
    Created on : 16/08/2020, 14:32:11
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
           String error =(String)request.getSession().getAttribute("Myerror");
        
        
        %>
        <p>Error <% out.print(error);%></p>
    </body>
</html>
