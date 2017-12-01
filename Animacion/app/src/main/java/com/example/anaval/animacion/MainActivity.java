package com.example.anaval.animacion;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animacion = (AnimationDrawable) getResources().getDrawable(R.drawable.animacion);
        ImageView imagen = new ImageView(this);
        imagen.setBackgroundColor(Color.WHITE); //Le ponemos color de fondo
        imagen.setImageDrawable(animacion); //Cargamos una animación.
        setContentView(imagen);
    }
    public boolean onTouchEvent(MotionEvent evento) {
        if (evento.getAction() == MotionEvent.ACTION_DOWN) {
            animacion.start(); //Ponemos en marcha la animación
            return true;
        }
        return super.onTouchEvent(evento);
    }
}

