
package edu.ulima.servlets;

import edu.ulima.bean.Libro;
import edu.ulima.jdbc.GestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
public class MostrarLibro extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        int idLibro = Integer.parseInt(request.getParameter("idLibro"));
        GestionDAO Gestion = new GestionDAO();
        Libro libro = Gestion.mostrarLibro(idLibro);
        request.setAttribute("libro", libro );
        System.out.println(libro.getNombre());
        getServletContext().getRequestDispatcher("/MostrarLibro.jsp").forward(request, response);
        
        
        
    }



}
