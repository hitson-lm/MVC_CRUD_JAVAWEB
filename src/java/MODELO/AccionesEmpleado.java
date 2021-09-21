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
    buscarEmpleados ->    int id        (solo requiere del parametro id) no interactua con todo los campos 
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
            
            estatus = ps.executeUpdate(); //executeUpdate te arroja un objeto de tipo int. que indica el número de filas afectadas
            System.out.println("Registro existoso del empleado!");
            
        } catch (Exception ed) {
            System.out.println("Error al registrar al empleado");
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
            
            // la Variable "rs" alamcena un conjunto de filas o tuplas (tabla). 
            ResultSet rs = ps.executeQuery(); // executeUpdate te arroja un objeto de tipo int. En este caso el "rs" esta apuntando al tupla o fila "0".
            
            // y para recorrer cada fila de esta tabla usamos rs.next() --> fila 1 (con todo los campos).
            while (rs.next()) {  // usamos While, porque no sabes cuantas registros haya en la BD.
                
                Empleado e = new Empleado();
                
                e.setId(rs.getInt(1)); // obtiene el dato de la columna(1) "idempleado" 
                e.setNombres(rs.getString(2)); // obtiene el dato de la columna(2) "nomEmpleado"
                e.setDireccion(rs.getString(3)); // obtiene el dato de la columna(3) "dorecEmpleado"
                
                listaEmpleados.add(e); // Agregamos a la listaEmpleados.
            }
            
            
            System.out.println("Lista de Empleados Encontrado!");
            
        } catch (Exception ed) {
            System.out.println("Error!! Lista de Empleados no Encontrado");
        }
        return listaEmpleados;
           
    }
    
    
}
