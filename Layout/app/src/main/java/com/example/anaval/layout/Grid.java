package com.example.anaval.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        final Button atras = (Button)findViewById(R.id.botonVuelta);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent = new Intent(Grid.this, MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}
