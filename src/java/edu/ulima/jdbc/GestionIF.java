
package edu.ulima.jdbc;

import edu.ulima.bean.Libro;
import edu.ulima.bean.Usuario;
import java.util.List;


public interface GestionIF {
    
    public Usuario login(Usuario usuario);
    public boolean registrarLibro(Libro libro);
    public Libro mostrarLibro(int id);
    public List<Libro> mostrarLibros();
    public boolean modificarLibro(Libro libro);
    public boolean cambiarEstado(Libro libro);
}
