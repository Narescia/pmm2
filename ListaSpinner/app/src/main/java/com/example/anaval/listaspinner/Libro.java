package com.example.anaval.listaspinner;

public class Libro {
    private String nombre;
    private String genero;
    private int paginas;

    public Libro(String tit, String gen, int pag) {
        nombre = tit;
        genero = gen;
        paginas = pag;
    }

    public String getTitulo(){

        return nombre;
    }

    public String getGenero(){

        return genero;
    }
    public int getPaginas(){

        return paginas;
    }

}
