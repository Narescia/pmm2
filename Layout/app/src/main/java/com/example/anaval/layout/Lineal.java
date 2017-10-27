package com.example.anaval.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lineal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineal);

        final Button atras = (Button)findViewById(R.id.botonVuelta);
        final Button colorRosa = (Button)findViewById(R.id.botRosa);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent = new Intent(Lineal.this, MainActivity.class);
                startActivity(miIntent);
            }
        });

        colorRosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                

            }
        });
    }
}
