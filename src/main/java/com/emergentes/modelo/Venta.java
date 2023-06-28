package com.emergentes.modelo;
public class Venta {
    private int id_venta;
    private String fecha;
    private int tienda_id;
    private int ci_vendedor;
    private int ci_cliente;

    public Venta() {
        this.id_venta = 0;
        this.fecha = "";
        this.tienda_id = 0;
        this.ci_vendedor = 0;
        this.ci_cliente = 0;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setIdventa(int venta) {
        this.id_venta = venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTienda_id() {
        return tienda_id;
    }

    public void setTienda_id(int tienda_id) {
        this.tienda_id = tienda_id;
    }

    public int getCi_vendedor() {
        return ci_vendedor;
    }

    public void setCi_vendedor(int ci_vendedor) {
        this.ci_vendedor = ci_vendedor;
    }

    public int getCi_cliente() {
        return ci_cliente;
    }

    public void setCi_cliente(int ci_cliente) {
        this.ci_cliente = ci_cliente;
    }
    
}
