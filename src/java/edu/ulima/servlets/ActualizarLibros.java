
package edu.ulima.servlets;


import edu.ulima.bean.Libro;
import edu.ulima.jdbc.GestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 */
public class ActualizarLibros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        GestionDAO Gestion = new GestionDAO();
        HttpSession sesion=request.getSession();
        

        int idLibro=(Integer)sesion.getAttribute("idLibro");        
        String nombre = request.getParameter("nombre");
        String editorial = request.getParameter("editorial");
        int año = Integer.parseInt( request.getParameter("anho") ) ;
        String autor = request.getParameter("autor");
        String estado = request.getParameter("estado");
        String descripcion = request.getParameter("descripcion");

        Libro libro=new Libro( idLibro, nombre , autor, editorial , año , estado , descripcion );

        //System.out.println(libro.getAutor());
        //System.out.println(libro.getAño());
        
        Gestion.modificarLibro(libro);
        response.sendRedirect("MostrarLibros");
       
        
    }


}
