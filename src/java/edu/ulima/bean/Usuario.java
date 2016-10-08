
package edu.ulima.bean;


public class Usuario {
    
    private int idUsuario;
    private String usuario;
    private String password;
    private String nombre;
    private String tipo;

    
    
    public Usuario(int idUsuario, String usuario, String password, String nombre, String tipo) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Usuario() {
    }
    
    

    public int getId() {
        return idUsuario;
    }

    public void setId(int id) {
        this.idUsuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
