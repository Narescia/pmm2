package com.example.anaval.bdinicial;

/**
 * Created by anaval on 16/01/18.
 */

public class Cliente {
    private String nombre;
    private String telefono;

    public Cliente(String nom, String tel) {
        nombre = nom;
        telefono = tel;
    }

    public String getNombre(){

        return nombre;
    }

    public String getTelefono(){

        return telefono;
    }
}
