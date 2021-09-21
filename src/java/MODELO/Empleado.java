
package MODELO;

/**
 *
 * @author Hitson Lapa Marcelo
 */
public class Empleado {
    private int id;
    private String nombres;
    private String direccion;

    // CONSTRUCTOR
    public Empleado() {
    }
    
    // METODOS GET Y SETERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
   
}
