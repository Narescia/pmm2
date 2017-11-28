package com.example.anaval.spinnerpeliculas;

import java.io.Serializable;

/**
 * Created by anaval on 28/11/17.
 */

public class Pelicula implements Serializable{
    private String titulo;
    private int añoEstreno;

    public Pelicula(String tit, int año) {
        titulo = tit;
        añoEstreno = año;
    }

    public String getTitulo(){

        return titulo;
    }

    public int getAño(){

        return añoEstreno;
    }


}
