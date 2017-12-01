package com.example.anaval.graficosmezclados2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * Created by anaval on 3/11/17.
 */

public class VistaDibujo extends View {
    private ShapeDrawable miDrawable;

    public VistaDibujo(Context c) {
        super(c);
    }
    public VistaDibujo(Context c, AttributeSet attrs){
        super(c,attrs);
    }

    protected void onDraw(Canvas lienzo){
        Paint miPincel = new Paint();
        miPincel.setColor(Color.BLUE);
        miPincel.setStyle(Paint.Style.STROKE);

        for(int i=0;i<90;i++)
            lienzo.drawCircle(500,500,300+i*3,miPincel);

        miPincel.setTextSize(60);
        lienzo.drawText("Mi círculo", 500, 900, miPincel);
        String mensaje = "Ancho: " + getWidth() + " Alto:" + getHeight();
        lienzo.drawText(mensaje, 500,1000,miPincel);


        //Otro modo
        ShapeDrawable miDrawable;
        int x = 300; int y = 1050;
        int ancho = 500, alto = 300;
        miDrawable = new ShapeDrawable(new OvalShape());
        miDrawable.getPaint().setColor(0xff0000ff);
        miDrawable.setBounds(x, y, x + ancho, y + alto);

        miDrawable.draw(lienzo);
    }
}
