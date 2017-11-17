package com.example.anaval.examenanatorres;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dibujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo);
    }

    public class Dibujado extends View {
        public Dibujado(Context context) {
            super(context);
        }


        protected void onDraw(Canvas canvas) {
            Paint circulo = new Paint();

            circulo.setColor(Color.BLACK);
            circulo.setStrokeWidth(15);
            circulo.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(550,450,150,circulo);
        }

    }
}
