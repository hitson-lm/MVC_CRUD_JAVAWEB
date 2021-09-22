/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServeletControlador;

import MODELO.AccionesEmpleado;
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
@WebServlet(name = "borrarEmpleado", urlPatterns = {"/borrarEmpleado"})
public class borrarEmpleado extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            // 1) obtener los parametros que vienen por parte del formulario.
            // requeste.getParameter(): Se utiliza para recoger parametros enviados por una peticion get o post. Por ejemplo: String 
            int id =Integer.parseInt(request.getParameter("id"));  // para eliminar el empleado requerimos del parametro "id"
            
            // llamamos la funcion eliminarEmpleado(int id) de la clase AccionesEmpleados
            int estado=AccionesEmpleado.eliminarEmpleado(id);
            
            if(estado>0){
                // el método sendRedirect("ejemplo.jsp") funciona en el lado del cliente
                response.sendRedirect("registroEmpleado.jsp"); // se puede utilizar para redirigir la respuesta a otro recurso, puede ser un archivo servlet, jsp o html.
            }
            else{
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
