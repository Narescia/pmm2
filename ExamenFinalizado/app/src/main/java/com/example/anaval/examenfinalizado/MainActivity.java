package com.example.anaval.examenfinalizado;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Pizza[] datos = new Pizza[]{
            new Pizza("Margarita", "jamón/tomate ", 10, R.drawable.pizza2),
            new Pizza("Barbacoa", "carne/tomate", 20, R.drawable.pizza3),
            new Pizza("Tres quesos", "queso1/queso2", 15, R.drawable.pizza4)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorPizza adaptador = new AdaptadorPizza(this);
        final Spinner pizzas = (Spinner) findViewById(R.id.pizza);
        pizzas.setAdapter(adaptador);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.acerca:
                Intent acerca = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(acerca);
                return true;
            case R.id.dibujar:
                Intent dibujo = new Intent(MainActivity.this, Dibujo.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ViewHolder {
        TextView nombre;
        TextView descripcion;
        TextView precio;
        ImageView imagen;
    }

    class AdaptadorPizza extends ArrayAdapter<Pizza> {
        Activity context;

        AdaptadorPizza(Activity context) {
            super(context, R.layout.spinner_pizza, datos);
            this.context = context;
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
                item = inflater.inflate(R.layout.spinner_pizza, null);

                holder = new ViewHolder();
                holder.nombre = (TextView) item.findViewById(R.id.nombre);
                holder.descripcion = (TextView) item.findViewById(R.id.descripcion);
                holder.precio = (TextView) item.findViewById(R.id.precio);
                ImageView imagen = (ImageView) item.findViewById(R.id.piImagen);
                imagen.setBackground(getDrawable(datos[position].getImagen()));
                item.setTag(holder);

            } else {
                holder = (ViewHolder) item.getTag();
            }
            holder.nombre.setText(datos[position].getNombre());
            holder.descripcion.setText(datos[position].getDescripcion());
            holder.precio.setText(datos[position].getPrecio());
            //holder.imagen.(datos[position].getImagen());
            return (item);

        }
    }
}
