package com.example.anaval.spinnerpeliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

      Bundle mibundle = getIntent().getExtras();

        Pelicula peli = (Pelicula) mibundle.getSerializable("clave");

        TextView titulo = (TextView)findViewById(R.id.titulo);

        titulo.setText(peli.getTitulo());

        TextView añoEstreno = (TextView)findViewById(R.id.añoEstreno);

        añoEstreno.setText(peli.getAño());
    }
}
