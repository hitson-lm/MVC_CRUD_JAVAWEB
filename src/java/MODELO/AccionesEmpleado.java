/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import CONFIGURACION.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hitson Lapa Marcelo
 */
public class AccionesEmpleado {
    /*
    
    Son toda las operaciones o "REQUERIMIENTOS FUNCIONALES" con que el usuario operará con el sistema.
    
    "FUNCIONES DE UNA CRUD"
                         |PARAMETROS|
    registrarEmpleado ->  Empleado e  (requiere del parametro del objeto empleado) porque el usuario va interactuar con todo los campos.
    actualizarEmpleado -> Empleado e (requiere del parametro del objeto empleado) porque el usuario va interactuar con todo los campos.
    eliminarEmpleado ->   int id       (solo requiere del parametro id) no interactua con todo los campos 
    buscarEmpleado ->    int id        (solo requiere del parametro id) no interactua con todo los campos 
    ListarTodoslosEmpleados ->(ningun parametro)     (Esta funcion debe retornar un Arraylista de un tipo de objeto ArrayList<tipo_de_dato> ) porque es capas de manipular diferentes tipos de dato. y es dinamico.   
    verificarUsuario ->   String user,pass
    
    */
    
    // CREAMOS LOS METODOS O FUNCIONES DEL SISTEMA
    public static int registrarEmpleado(Empleado e){   //funcion de tipo "int" porque vamos verificar si lo hace o no lo hace.
        int estatus=0;  //sirve para saber si estas realizando o no la operacion.
        
        try {
            Connection con=Conexion.conectar(); //llamamos la funcion conectar(), para hacer la conexion previa.
            String sql = "insert into empleados(nomEmpleado,direcEmpleado) values(?,?)"; // establecemos la consulta para luego prepararlo
            // prepara y establece la sentencia sql
            PreparedStatement ps = con.prepareStatement(sql);
            
            //usar getter and setter || PARAMETROS QUE REQUIERE LA FUNCION
            ps.setString(1, e.getNombres());
            ps.setString(2, e.getDireccion());
            
            // USE executeUpdate()
            //Para intrucciones SQL: INSERT, UPDATE(Actualizar), MERGE(ir) o DELETE; o una sentencia SQL que no devuelve nada, como una sentencia DDL de SQL.
            estatus = ps.executeUpdate(); //executeUpdate te arroja un objeto de tipo int. que indica el número de filas afectadas
            System.out.println("Registro existoso del empleado!");
            
        } catch (Exception ed) {
            System.out.println("Error al registrar al empleado "+ed);
        }
        return estatus;
        
        
    }
    
    
    public static ArrayList<Empleado> listarTodolosEmpleados(){   //funcion de tipo "ArrayList" para retornar todo los empleados.
        //Crea un ArrayList objeto llamado "listaEmpleados" que almacenará objetos de tipo "Empleado":
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        
        try {
            Connection con=Conexion.conectar(); //llamamos la funcion conectar(), para hacer la conexion previa.
            String sql = "select * from empleados"; // establecemos la consulta para luego prepararlo
            // prepara y establece la sentencia sql
            PreparedStatement ps = con.prepareStatement(sql);
            
            //usar getter and setter|| NO REQUIERE NIGUN PARAMETRO EN ESTA FUNCION
            
            /*      ps.setString(1, e.getNombres());
                    ps.setString(2, e.getDireccion());
            */  
            
            // Use executeQuery()
            // Este método se utiliza para ejecutar una instrucción SELECT, que es casi la instrucción SQL más utilizada.
            // la Variable "rs" almacena un conjunto de filas o tuplas (tabla). 
            ResultSet rs = ps.executeQuery(); //executeQuery te arroja una tabla con lo datos, pero no te lee los contenidos de las tuplas o filas. porque su cursor esta en la fila "0"
            
            // y para recorrer cada fila de esta tabla usamos rs.next() --> fila 1 (con todo los campos).
            while (rs.next()) {  // usamos While, porque no sabes cuantas registros -> (tuplas) haya en la BD.
                
                Empleado e = new Empleado();
                
                e.setId(rs.getInt(1)); // obtiene el dato de la [columna(1) "idempleado" - Fila 1] y luego se le establece el dato al obejto empleado.
                e.setNombres(rs.getString(2)); // obtiene el dato de la [columna(2) "nomEmpleado" - Fila 1] y luego se le establece el dato al obejto empleado.
                e.setDireccion(rs.getString(3)); // obtiene el dato de la [columna(3) "dorecEmpleado" - Fila 1] y luego se le establece el dato al obejto empleado.
                
                listaEmpleados.add(e); // Agregamos a la listaEmpleados.
            }
            
            
            System.out.println("Lista de Empleados Encontrado!");
            
        } catch (Exception ed) {
            System.out.println("Error!! Lista de Empleados no Encontrado "+ed);
        }
        return listaEmpleados;
           
    }
    
    public static int actualizarEmpleado(Empleado e){   //funcion de tipo "int" porque vamos verificar si lo hace o no lo hace.
        int estatus=0;  //sirve para saber si estas realizando o no la operacion.
        
        try {
            Connection con=Conexion.conectar(); //llamamos la funcion conectar(), para hacer la conexion previa.
            String sql = "update empleados set nomEmpleado=?,direcEmpleado=? where idempleado=?"; // establecemos la consulta para luego prepararlo
            // prepara y establece la sentencia sql
            PreparedStatement ps = con.prepareStatement(sql);
            
            //usar getter and setter || PARAMETROS QUE REQUIERE LA FUNCION para actualizar o modificar empleado
            ps.setString(1, e.getNombres());
            ps.setString(2, e.getDireccion());
            ps.setInt(3, e.getId());
            
            // USE executeUpdate()
            //Para intrucciones SQL: INSERT, UPDATE(Actualizar), MERGE(ir) o DELETE; o una sentencia SQL que no devuelve nada, como una sentencia DDL de SQL.
            estatus = ps.executeUpdate(); //executeUpdate te arroja un objeto de tipo int. que indica el número de filas afectadas
            System.out.println("Actualizar empleado existoso!!!");
            
        } catch (Exception ed) {
            System.out.println("Error al Actualizar empleado "+ed);
        }
        return estatus;
           
    }
    
    public static int eliminarEmpleado(int id){   //funcion de tipo "int" porque vamos verificar si lo hace o no lo hace.
        int estatus=0;  //sirve para saber si estas realizando o no la operacion.
        
        try {
            Connection con=Conexion.conectar(); //llamamos la funcion conectar(), para hacer la conexion previa.
            String sql = "delete from empleados where idempleado=?"; // establecemos la consulta para luego prepararlo
            // prepara y establece la sentencia sql
            PreparedStatement ps = con.prepareStatement(sql);
            
            //PARAMETROS QUE REQUIERE LA FUNCION para eliminar empleado
            ps.setInt(1,id); // se establece el identificador como parametro esto se hace para introducir al signo --> "?" | idempleado=? | de la consulta SQL
            
            // USE executeUpdate()
            //Para intrucciones SQL: INSERT, UPDATE(Actualizar), MERGE(ir) o DELETE; o una sentencia SQL que no devuelve nada, como una sentencia DDL de SQL.
            estatus = ps.executeUpdate(); //executeUpdate te arroja un objeto de tipo int. que indica el número de filas afectadas
            System.out.println("Borrado del empleado existoso!!!");
            
        } catch (Exception ed) {
            System.out.println("Error al Borrar empleado "+ed);
        }
        return estatus;   
    }
    
    public static Empleado buscarEmpleado(int id){   //funcion de tipo "Empleado".(buscaremos por el "id" una vez encontrado esto retornará un objeto de tipo Empleado, con todo los campos)
        //instanciamos el objeto empleado.
        Empleado e = new Empleado();
        
        try {
            Connection con=Conexion.conectar(); //llamamos la funcion conectar(), para hacer la conexion previa.
            String sql = "select from empleados where idempleado=?"; // establecemos la consulta para luego prepararlo
            
            // prepara y establece la sentencia sql
            PreparedStatement ps = con.prepareStatement(sql);
            
            //PARAMETROS QUE REQUIERE LA FUNCION para buscar empleado
            ps.setInt(1,id); // se establece el identificador como parametro esto se hace para asignarle el valor al signo --> "?" | idempleado=? | de la consulta SQL
            
            // Use executeQuery()
            // Este método se utiliza para ejecutar una instrucción SELECT, que es casi la instrucción SQL más utilizada.
            ResultSet rs = ps.executeQuery(); //executeQuery te arroja una tabla con lo datos, pero no te lee los contenidos de las tuplas o filas. porque su cursor esta en la fila "0"
            
            if(rs.next()){ // para que el cursor pase de la fila "0" a la fila 1. usaremos | rs.next() | 
                
                e.setId(rs.getInt(1));      // obtenemos el dato de la bd de la (columna "1" o "idempleado" - FILA 1) y luego se le establece el dato al obejto empleado. 
                e.setNombres(rs.getString("nomEmpleado")); // obtenemos el dato de la bd de la (columna "2" o "nomEmpleado" - FILA 1) y luego se le establece el dato al obejto empleado.
                e.setDireccion(rs.getString(3));           // obtenemos el dato de la bd de la (columna "3" o "direcEmpleado" - FILA 1) y luego se le establece el dato al obejto empleado.
            }
            System.out.println("Empleado encontrado!!!");
            
        } catch (Exception ed) {
            System.out.println("Error!! empleado no encontrado "+ed);
        }
        return e;   
    }
}
