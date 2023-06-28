package com.emergentes.modelo;

public class Tienda {

    private int id_tienda;
    private String direccion;
    private String ciudad;
    private int telefono;

    public Tienda() {
        this.id_tienda = 0;
        this.direccion = "";
        this.ciudad = "";
        this.telefono = 0;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
