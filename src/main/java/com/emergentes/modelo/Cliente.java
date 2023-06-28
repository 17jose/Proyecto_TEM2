package com.emergentes.modelo;

public class Cliente {
    private int id;
    private int ci;
    private String nombre;
    private String apellidos;
    private String celular;

    public Cliente() {
        this.id = 0;
        this.ci = 0;
        this.nombre = "";
        this.apellidos = "";
        this.celular = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
