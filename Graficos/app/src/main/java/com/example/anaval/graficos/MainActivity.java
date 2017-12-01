package com.example.anaval.graficos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));

    }

    class MiDibujo extends View {
        public MiDibujo(Context c){
            super(c);
        }

        protected void onDraw (Canvas lienzo){
            Paint miPincel = new Paint();
            miPincel.setColor(Color.BLUE);
            miPincel.setStyle(Paint.Style.STROKE);

            for(int i=0;i<90;i++)
                lienzo.drawCircle(500,500,300+i*3,miPincel);

            miPincel.setTextSize(60);
            lienzo.drawText("Mi círculo", 500, 900, miPincel);
            String mensaje = "Ancho: " + getWidth() + " Alto:" + getHeight();
            lienzo.drawText(mensaje, 500,1000,miPincel);
            Toast.makeText(getApplicationContext(), "mas dibujos", Toast.LENGTH_SHORT).show();

            //Otro modo
            ShapeDrawable miDrawable;
            int x = 300; int y = 1050;
            int ancho = 500, alto = 300;
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x, y, x + ancho, y + alto);

            miDrawable.draw(lienzo);

            BitmapDrawable imagen;

            Resources res = this.getResources();
            imagen = (BitmapDrawable)res.getDrawable(R.drawable.silueta);
            imagen.setBounds(new Rect(200,400,500,1200));
            imagen.draw(lienzo);

        }
    }
}
