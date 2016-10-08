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
public class IngresarLIbros extends HttpServlet {


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
        boolean exito = Gestion.registrarLibro(libro);
        
        if (exito){
        response.sendRedirect("MostrarLibros");
        } else {
        request.getSession().setAttribute("mensaje", "id ya existente");
        response.sendRedirect("IngresarLibros.jsp");    
        }
        
        
 
    }

 
}
