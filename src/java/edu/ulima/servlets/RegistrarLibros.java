/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.servlets;

import edu.ulima.bean.Libro;
import edu.ulima.jdbc.GestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
public class RegistrarLibros extends HttpServlet {

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
        

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        GestionDAO Gestion = new GestionDAO();
        int idLibro = Integer.parseInt(request.getParameter("idLibro") );
        String nombre = request.getParameter("nombre");
        String editorial = request.getParameter("editorial");
        int año = Integer.parseInt( request.getParameter("anho") ) ;
        String autor = request.getParameter("autor");
        String estado = request.getParameter("estado");
        String descripcion = request.getParameter("descripcion");
        Libro libro=new Libro(idLibro,nombre,autor,editorial,año,estado,descripcion);
        Gestion.registrarLibro(libro);
        response.sendRedirect("MostrarLibros");
        
    }


}
