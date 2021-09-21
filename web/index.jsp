
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>

    <body>
        <div class="container mt-5">

            <form action="guardarEmpleado" method="post" name="registroEmpleado"> <!-- con el atributo "action" mandamos el formulario al Controlador "guardarEmpleado", tambien escoges el tipo de metodo, post o get. -->
                <div class="form-group">
                    <label>Nombres</label>
                    <input type="text" name="txtNombre"class="form-control" placeholder="nombres">
                </div>
                <div class="form-group">
                    <label>Direccion</label>
                    <input type="text" name="txtDireccion"class="form-control" placeholder="direccion">
                </div>

                <div>
                    <input type="submit" name="accion" value="Registrar">
                </div>
            </form>

        </div>
    </body>
</html>
