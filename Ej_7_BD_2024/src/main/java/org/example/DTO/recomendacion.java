package org.example.DTO;
import org.example.entities.*;
public class recomendacion {
    private int id;
    private int producto_id;
    private String texto;
    private int valoracion;
    public recomendacion(recomendaciones r){
        int Id=r.getId();
        String texto=r.getTexto();
        int valoracion=r.getValoracion();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
