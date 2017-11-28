package com.example.anaval.spinnerpeliculas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Pelicula[] datos = new Pelicula[]{
            new Pelicula ("Pequeña Miss Sunshine", 2006),
            new Pelicula ("El gran hotel Budapest", 2014)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorPelicula adaptador = new AdaptadorPelicula(this);
        final Spinner peliculas = (Spinner) findViewById(R.id.peliculas);
        peliculas.setAdapter(adaptador);

        peliculas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id){
                Pelicula pelicula = datos[position];
                Intent mIntent = new Intent(MainActivity.this,Pantalla2.class);
                Bundle miBundle = new Bundle();
                miBundle.putSerializable("clave", pelicula);
                mIntent.putExtras(miBundle);

                startActivity(mIntent);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    class AdaptadorPelicula extends ArrayAdapter<Pelicula> {
        Activity context;

        AdaptadorPelicula(Activity context) {
            super(context, R.layout.spinner_pelicula, datos);
            this.context = context;
        }
        class ViewHolder {
            TextView titulo;
            TextView añoEstreno;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;
            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.spinner_pelicula, null);

                holder = new ViewHolder();
                holder.titulo = (TextView) item.findViewById(R.id.titulo);
                holder.añoEstreno = (TextView) item.findViewById(R.id.añoEstreno);
                item.setTag(holder);

            } else {
                holder = (ViewHolder) item.getTag();
            }
            holder.titulo.setText(datos[position].getTitulo());
            holder.añoEstreno.setText(String.valueOf(datos[position].getAño()));
            //holder.imagen.(datos[position].getImagen());
            return (item);

        }
    }
}
