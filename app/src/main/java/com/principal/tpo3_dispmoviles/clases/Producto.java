package com.principal.tpo3_dispmoviles.clases;

import java.io.Serializable;

public class Producto implements Serializable {
    private String codigo;
    private String descripcion;
    private double precio;


    public Producto(String codigo,String descripcion,double precio) {
        this.codigo = codigo;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
