
package edu.ulima.servlets;
import edu.ulima.bean.Usuario;
import edu.ulima.jdbc.GestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        GestionDAO Gestion = new GestionDAO();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");        
        Usuario usuario = new Usuario();
        usuario.setUsuario(user);
        usuario.setPassword(pass);
        usuario = Gestion.login(usuario);   
        if (usuario == null){
        response.sendRedirect("");
        } else 
        {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("nombre", usuario.getNombre());
        sesion.setAttribute("TipoUsuario", usuario.getTipo());
        System.out.println(usuario.getNombre() + usuario.getTipo());
        response.sendRedirect("MostrarLibros");
        }
        
    }


    
}
