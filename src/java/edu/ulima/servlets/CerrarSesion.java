
package edu.ulima.servlets;

import edu.ulima.bean.Libro;
import edu.ulima.jdbc.GestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CerrarSesion extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {              
        
        }
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
    response.setContentType("text/html;charset=UTF-8");
    HttpSession sesion=request.getSession(true);
    sesion.invalidate();
    response.sendRedirect("login.html");
        
       
        
}
}



