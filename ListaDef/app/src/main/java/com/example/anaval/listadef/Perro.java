package com.example.anaval.listadef;

import java.io.Serializable;

/**
 * Created by anaval on 20/10/17.
 */

public class Perro implements Serializable{
    private String titulo;
    private String subtitulo;
    private int imagen;

    public Perro(String tit, String sub, int dog){
        titulo = tit;
        subtitulo = sub;
        imagen = dog;
    }


    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }
    public int getImagen(){
        return imagen;
    }
}
