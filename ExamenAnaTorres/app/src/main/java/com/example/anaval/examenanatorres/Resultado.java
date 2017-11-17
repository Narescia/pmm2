package com.example.anaval.examenanatorres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView resultado_pizza=(TextView)findViewById(R.id.resultado_pizza);
        TextView resultado_extra=(TextView)findViewById(R.id.resultado_extra);
        TextView resultado_precio=(TextView)findViewById(R.id.resultado_precio);
        TextView resultado_unidades=(TextView)findViewById(R.id.resultado_unidades);
        TextView resultado_envio=(TextView)findViewById(R.id.resultado_envio);
        TextView resultado_final=(TextView)findViewById(R.id.resultado_final);

        Bundle miBundle = getIntent().getExtras();
        Pizza pizza = (Pizza) miBundle.getSerializable("Informacion");

        resultado_pizza.setText(pizza.getNombre());
        resultado_precio.setText(pizza.getPrecio());
    }
}
