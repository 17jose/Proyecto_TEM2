package com.emergentes.modelo;

public class Producto {

    private int producto_id;
    private String nombre_prod;
    private int precio;
    private int stock_id;
    private int marca_id;
    private int categoria_id;

    public Producto() {
        this.producto_id = 0;
        this.nombre_prod = "";
        this.precio = 0;
        this.stock_id = 0;
        this.marca_id = 0;
        this.categoria_id = 0;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

}
