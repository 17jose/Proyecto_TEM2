package com.emergentes.modelo;

public class Vendedor {
    private int id;
    private int ci_vendedor;
    private String nombre_vendedor;
    private String apellido_paterno;
    private String apellido_materno;
    private int celular;
    private int id_tienda;

    public Vendedor() {
        this.id = 0;
        this.ci_vendedor = 0;
        this.nombre_vendedor = "";
        this.apellido_paterno = "";
        this.apellido_materno = "";
        this.celular = 0;
        this.id_tienda = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCi_vendedor() {
        return ci_vendedor;
    }

    public void setCi_vendedor(int ci_vendedor) {
        this.ci_vendedor = ci_vendedor;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }
    
    
    
}
