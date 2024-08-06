package org.example.DTO;
import org.example.entities.*;
public class producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int Categoria_id;
    public producto(productos p){
        int id=p.getId();
        String Nombre=p.getNombre();
        String descripcion=p.getDescripcion();
        int Categoria_id= p.getCategoria().getId();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria_id() {
        return Categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.Categoria_id = categoria_id;
    }
}
