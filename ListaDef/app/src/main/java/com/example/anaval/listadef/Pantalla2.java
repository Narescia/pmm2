package com.example.anaval.listadef;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        TextView elSaludo =(TextView)findViewById(R.id.nombre);

        Bundle mibundle = getIntent().getExtras();

        Perro p = (Perro) mibundle.getSerializable("clave");

        TextView nombre = (TextView)findViewById(R.id.nombre);

        nombre.setText(p.getTitulo());

        TextView subtitulo = (TextView)findViewById(R.id.subtitulo);

        subtitulo.setText(p.getSubtitulo());

        ImageView imagen = (ImageView) findViewById(R.id.imagePantalla2);
        imagen.setBackground(getDrawable(p.getImagen()));

        elSaludo.setText("Hola " + p.getTitulo());
    }
}
