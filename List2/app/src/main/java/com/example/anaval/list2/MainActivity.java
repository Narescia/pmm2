package com.example.anaval.list2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView view1;

    final static String semana[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensaje;

        view1 = (ListView)findViewById(R.id.LstOpciones);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, semana);
        view1.setAdapter(miAdaptador);

        view1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int position, long id){
                String mensaje = "Item clicked => " + semana[position];
                showToast(mensaje);

            }

            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });
    }

    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
