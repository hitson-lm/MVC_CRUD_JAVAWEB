/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServeletControlador;

import MODELO.AccionesEmpleado;
import MODELO.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hitson Lapa Marcelo
 */
@WebServlet(name = "guardarEmpleado", urlPatterns = {"/guardarEmpleado"})
public class guardarEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // 1) obtener los parametros que vienen por parte del formulario.
                // requeste.getParameter(): Se utiliza para recoger parametros enviados por una peticion get o post. Por ejemplo: String 
            String nom = request.getParameter("txtNombre"); //almacenamos en la variable, los datos ingresados por el formulario.
            String direc = request.getParameter("txtDireccion");
            
            // hacemos instancia del empleado, porque tenemos q enviar estos "parametros obtenidos del form" al objeto empleado.
            Empleado e = new Empleado();
            
            e.setNombres(nom);  //establecemos el dato ingresado por el formulario, que esta almacenado en la variable "nom"
            e.setDireccion(direc); //establecemos el dato ingresado por el formulario, que esta almacenado en la variable "direc"
            
            int estatus = AccionesEmpleado.registrarEmpleado(e);  // manda a llamar la accion, y verifica en que estado está, "estatus=0" (nose registró) // "estatus > 0" se registro el usuario
            
            if (estatus>0) {
                // da la respuesta y redirecciona a una vista.
                response.sendRedirect("registroEmpleado.jsp");
                
            }
            else{
                // da la respuesta y redirecciona a una vista de error.
                response.sendRedirect("error.jsp");
            }
            
            
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
