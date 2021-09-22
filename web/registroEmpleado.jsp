<%-- 
    Document   : registroEmpleado
    Created on : 21-sep-2021, 1:15:26
    Author     : Hitson Lapa Marcelo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Empleado"%>
<%@page import="MODELO.AccionesEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th class="text-center" scope="col">ID</th>
                        <th class="text-center" scope="col">NOMBRES</th>
                        <th class="text-center" scope="col">DIRECCION</th>
                        <th class="text-center" scope="col">ACIONES</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Empleado> listaEmpleados = AccionesEmpleado.listarTodolosEmpleados(); // llamo a la funcion "listarTodolosEmpleados" a partir de la clase "AccionesEmpleado"
                        
                        // Ahorra recorremos todo los objetos de la lista. con un FOR
                        for (Empleado e : listaEmpleados) { // recorre desde el Empleado e Hasta el tañamo de la lista.
                            
                    %>         
                    <tr>
                        <th class="text-center" scope="row"><%= e.getId()%></th> <!-- obtenemos el "id" del objeto Empleado e -->
                        <td class="text-center" ><%= e.getNombres()%></td>       <!-- obtenemos el atributo "nombres" del objeto Empleado e -->
                        <td class="text-center" ><%= e.getDireccion()%></td>     <!-- obtenemos el atributo "direccion" del objeto Empleado e -->
                        <td class="text-center" >
                            <a class="btn btn-warning" href="">editar</a> 
                            <a class="btn btn-danger" href="">borrar</a> 
                        </td>
                    </tr>
                    
                </tbody>
                <%}%>
            </table>
        </div>

    </body>
</html>
