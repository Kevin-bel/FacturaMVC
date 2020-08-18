<%-- 
    Document   : index
    Created on : 16/08/2020, 14:23:19
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
        <form name="Principal"action="controlador" method="post">
            <table>
            <tr>
                <th>Producto<input type="text" name="txtpro" /><br><br></th> 
                <th>Cantidad<input type="text" name="txtcant" /> <br> <br></th>
                <th>Precio<input type="text" name="txtpre" /> <br> <br></th> 
            </tr>
            <tr>
                <th><input type="submit" value="Agregar" name="actionproceso" href="todo.jsp"/></th>
                <td><a href='todo.jsp'>Facturar</a></td>
                <td><a href='agregado.jsp'>Agregar</a></td>
            </tr>   
            </table>
         </form>
    </body>
</html>
