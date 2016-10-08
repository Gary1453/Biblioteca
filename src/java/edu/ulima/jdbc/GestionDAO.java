
package edu.ulima.jdbc;

import edu.ulima.bean.Libro;
import edu.ulima.bean.Usuario;
import edu.ulima.utils.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestionDAO implements GestionIF{

    @Override
    public Usuario login(Usuario usuario) {
        Connection con=DBConexion.getConnection();
        Usuario respuesta= null;
        PreparedStatement ps;
        ResultSet rs;
        String sql="SELECT idusuario, usuario, password, nombre, tipo from usuarios WHERE usuario = ? AND password = ?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            rs = ps.executeQuery();
            if(rs.next()){
                respuesta = new Usuario(rs.getInt(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                
            }
          
        } catch (SQLException ex) {
            
        }
         return respuesta;
        
    }

    @Override
    public boolean registrarLibro(Libro libro) {
        Connection con=DBConexion.getConnection();
        PreparedStatement ps;
       
        String sql="insert into libros values(?,?,?,?,?,?,?)";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, libro.getIdLibro());
            ps.setString(2, libro.getNombre());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getAño());
            ps.setString(6, libro.getEstado());
            ps.setString(7, libro.getDescripcion());
            ps.executeUpdate();
                
          return true ; 
          
        } catch (SQLException ex) {
            return false;
        }
       
    }

     @Override
    public Libro mostrarLibro(int id) {
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select * from libros where idlibro=?";
        Libro lib = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs= ps.executeQuery();
            
           while(rs.next()){
           lib = new Libro (rs.getInt(1), rs.getString(2), rs.getString(3), 
                   rs.getString(4), rs.getInt(5),rs.getString(6), rs.getString(7));
           
           }
           return lib;
         }catch(SQLException ex){
    return null;
    }
    
    
    }
    
    @Override
    public List<Libro> mostrarLibros() {
        List<Libro> libros = new ArrayList();
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select * from libros";
        Libro lib;
        
        try {
             
             ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            
           while(rs.next()){
           lib = new Libro (rs.getInt(1), rs.getString(2), rs.getString(3), 
                   rs.getString(4), rs.getInt(5),rs.getString(6), rs.getString(7));
           libros.add(lib);
           }
           return libros;
         }catch(SQLException ex){
    return null;
    }
    
    }

    @Override
    public boolean modificarLibro(Libro libro) {
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
      
        String sql= "update libros set nombre=?, autor=?, editorial=?, "
                + "año=?, estado=?, descripcion=? where idlibro = ?";
    
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,libro.getNombre());
            ps.setString(2,libro.getAutor());
            ps.setString(3,libro.getEditorial());
            ps.setInt(4,libro.getAño());
            ps.setString(5,libro.getEstado());
            ps.setString(6,libro.getDescripcion());
            ps.setInt(7,libro.getIdLibro());
                      
            ps.executeUpdate();
            
           
           return true;
         }catch(SQLException ex){
        return false;
    }
    }

    @Override
    public boolean cambiarEstado(Libro libro) {
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
      
        String sql= "update libros set estado=? where idlibro = ?";
    
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,libro.getEstado());
            ps.setInt(2,libro.getIdLibro());
                      
            ps.executeUpdate();
            
           
           return true;
         }catch(SQLException ex){
        return false;
    }}

   
    
}
