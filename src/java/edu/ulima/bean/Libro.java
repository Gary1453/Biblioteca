
package edu.ulima.bean;


public class Libro {
    
    private int idLibro;
    private String nombre;
    private String autor;
    private String editorial;
    private int año;
    private String estado;
    private String descripcion;

    public Libro(int idLibro, String nombre, String autor, String editorial, int año, String estado, String descripcion) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.año = año;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public Libro() {
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
