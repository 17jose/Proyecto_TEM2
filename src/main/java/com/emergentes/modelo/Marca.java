package com.emergentes.modelo;

public class Marca {
    private int marca_id;
    private String marca;

    public Marca() {
    this.marca_id = 0;
    this.marca = "";
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
