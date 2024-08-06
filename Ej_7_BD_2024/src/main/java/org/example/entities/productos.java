package org.example.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="productos")

public class productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private categorias categoria;
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<recomendaciones> recomendaciones;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(categorias categoria) {
        this.categoria = categoria;
    }

    public List<org.example.entities.recomendaciones> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<org.example.entities.recomendaciones> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
}
