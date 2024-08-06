package org.example.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categorias")
public class categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<productos> productos;

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

    public List<org.example.entities.productos> getProductos() {
        return productos;
    }

    public void setProductos(List<org.example.entities.productos> productos) {
        this.productos = productos;
    }
}
