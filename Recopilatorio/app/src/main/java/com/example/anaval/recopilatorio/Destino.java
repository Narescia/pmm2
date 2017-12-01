package com.example.anaval.recopilatorio;

/**
 * Created by anaval on 14/11/17.
 */

public class Destino {
        private String zona;
        private String continente;
        private int precio;

        public Destino(String zon, String cont, int preci) {
            zona = zon;
            continente = cont;
            precio = preci;
        }

        public String getZona(){

            return zona;
        }

        public String getContinente(){

            return continente;
        }
        public int getPrecio(){

            return precio;
        }



}

