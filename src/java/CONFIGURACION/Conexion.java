
package CONFIGURACION;

import java.sql.*;

/**
 *
 * @author Hitson Lapa Marcelo
 */
public class Conexion {
    
    // METODO PARA OBTENER LA CONEXION CON LA BASE DE DATOS
    // Este metodo retornará un objeto de tipo Connection.
    public static Connection conectar(){
        
        String url="jdbc:mysql://localhost:3306/hitson"; // ruta y nombre de la BD
        String nomUsuario="root";
        String password="admin";
        
        Connection con =null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // el Class.forName(), simplemente carga la clase con el nombre indicado.
            con=DriverManager.getConnection(url, nomUsuario, password); //, la clase DriverManager intentará cargar las clases de controladores
            System.out.println("Conexion Exitosa!");
            
        } catch (Exception e) {
            System.out.println("Error conexion "+e);
        }
        return con;
        
    } 
    
}
