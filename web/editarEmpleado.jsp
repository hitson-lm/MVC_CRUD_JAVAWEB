<%-- 
    Document   : editarEmpleado
    Created on : 22-sep-2021, 0:55:47
    Author     : Hitson Lapa Marcelo
--%>

<%@page import="MODELO.AccionesEmpleado"%>
<%@page import="MODELO.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-5 col col-sm-4">
            
            <form action="actualizarEmpleado" method="post" name="actualizarDatos"> <!-- con el atributo "action" mandamos el formulario al Controlador "actualizarEmpleado", tambien escoges el tipo de metodo, post o get. -->
                <%
                    // primero obtengo el identificador que es de tipo "int"
                    int id =Integer.parseInt(request.getParameter("id")); // el parametro "id" viene de la vista registroEmpleado.jsp || ?id=<%= e.getId()> 
                    
                    Empleado e = AccionesEmpleado.buscarEmpleado(id); // llamamos la funcion buscarEmpleado
                    
                   // una vez identificado al objeto empleado, mandamos a llamar los datos en el atributo value=" " 

                %>
                <div class="form-group">
                    <input type="hidden" name="id2" value="<%= e.getId()%>" >
                    <label>Nombres</label>
                    <input type="text" name="txtNombre2" value="<%= e.getNombres()%>">
                </div>
                <div class="form-group">
                    <label>Direccion</label>
                    <input type="text" name="txtDireccion2" value="<%= e.getDireccion()%>">
                    
                </div>

                <div>
                    <input type="submit" value="actualizar">
                </div>
            </form>
        </div>

    </body>
</html>
