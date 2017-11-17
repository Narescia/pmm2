package com.example.anaval.examenanatorres;

/**
 * Created by anaval on 17/11/17.
 */

public class Pizza {
    private String nombre;
    private String descripcion;
    private int precio;
    private int imagen;

    public Pizza(String nom, String des, int preci, int ima) {
        nombre = nom;
        descripcion = des;
        precio = preci;
        imagen = ima;
    }

    public String getNombre(){

        return nombre;
    }

    public String getDescripcion(){

        return descripcion;
    }
    public int getPrecio(){

        return precio;
    }

    public int getImagen(){
        return imagen;
    }
}
