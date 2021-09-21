/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import CONFIGURACION.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Hitson Lapa Marcelo
 */
public class AccionesEmpleado {
    /*
    
    Son toda las operaciones o "REQUERIMIENTOS FUNCIONALES" con que el usuario operará con el sistema.
    
    "FUNCIONES DE UNA CRUD"
    
    registrarEmpleado -> Empleado e  (requiere del parametro del objeto empleado) porque el usuario va interactuar con todo los campos.
    actualizarEmpleado -> Empleado e (requiere del parametro del objeto empleado) porque el usuario va interactuar con todo los campos.
    eliminarEmpleado -> int id       (solo requiere del parametro id) no interactua con todo los campos 
    buscarEmpleados -> int id        (solo requiere del parametro id) no interactua con todo los campos 
    buscarTodoslosEmpleados ->       (requiere de un tipo de objeto ArrayList<tipo_de_dato> ) porque es capas de manipular diferentes tipos de dato. y es dinamico.   
    verificarUsuario -> String user,pass
    
    */
    
    // CREAMOS LOS METODOS O FUNCIONES DEL SISTEMA
    public static int registrarEmpleado(Empleado e){   //funcion de tipo "int" porque vamos verificar si lo hace o no lo hace.
        int estatus=0;  //sirve para saber si estas realizando o no la operacion.
        
        try {
            Connection con=Conexion.conectar();
            String sql = "insert into empleados(nomEmpleado,direcEmpleado) values(?,?)";
            // prepara y establece la sentencia sql
            PreparedStatement ps = con.prepareStatement(sql);
            
            //usar getter and setter
            ps.setString(1, e.getNombres());
            ps.setString(2, e.getDireccion());
            
            estatus = ps.executeUpdate(); //executeUpdate te arroja un objeto de tipo int. que indica el número de filas afectadas
            System.out.println("Registro existoso del empleado!");
            
        } catch (Exception ed) {
            System.out.println("Error al registrar al empleado");
        }
        return estatus;
        
        
    }
    
    
    
}
