package com.emergentes.modelo;

public class Categoria {
    private int categoria_id;
    private String categoria;

    public Categoria() {
        this.categoria_id = 0;
        this.categoria = "";
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
