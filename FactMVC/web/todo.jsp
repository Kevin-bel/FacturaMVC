<%-- 
    Document   : todo
    Created on : 16/08/2020, 14:32:53
    Author     : Usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ec.edu.intsuperior.modelo.modelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form name="Principal"action="controlador" method="post">
            <%
            ArrayList<modelo> d= (ArrayList<modelo>)request.getSession().getAttribute("mypro");
            %>
            <table border="1">
                <tr>
                    <td>Cantidad</td>
                    <td>Producto</td>
                    <td>Precio</td>
                    <td>Precio Total</td>
                </tr>
                
                <%
                    if(d==null){
                    }else{
                        for(int i =0; i<d.size();i++){

                            out.println("<tr>");
                                out.println("<td>"+d.get(i).getNombre()+"</td>");
                                out.println("<td>"+d.get(i).getCantidad()+"</td>");
                                out.println("<td>"+d.get(i).getPecio()+"</td>");
                                out.println("<td>"+d.get(i).getTotalpaga()+"</td>");
                            out.println("</tr>");
                        }
                    }
                %>
            </table>
            <table border="1">
                <tr>
                    <td>Subtotal</td>
                    <td><% out.print(request.getAttribute("txtsub")); %></td> 
                </tr>
                <tr>
                    <td>iva</td>
                    <td><% out.print(request.getAttribute("txtiva"));  %></td> 
                </tr>
                <tr>
                    <td>Total a pagar</td>
                    <td><% out.print(request.getAttribute("txtTotal"));  %></td>
                </tr>
            </table>
                
        </form>
    </center>
        
    </body>
</html>
