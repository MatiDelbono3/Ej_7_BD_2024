package org.example.DTO;

import jakarta.persistence.OneToMany;

public class categoria {
    private int Id;
    private int Nombre;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int nombre) {
        Nombre = nombre;
    }
}
