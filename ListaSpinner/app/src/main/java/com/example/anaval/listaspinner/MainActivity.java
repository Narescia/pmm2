package com.example.anaval.listaspinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Spinner miSpinner;
    private Libro[] libros = new Libro[]{
            new Libro("Persuasión", "Clásico", 250),
            new Libro("Drácula", "Clásico-terror", 500)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.spLibros);
        AdaptadorLibro miAdaptador = new AdaptadorLibro(this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + libros[position];
                showToast(mensaje);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder {
        TextView nombre;
        TextView genero;
        TextView paginas;
    }

    class AdaptadorLibro extends ArrayAdapter<Libro> {
        Activity context;

        AdaptadorLibro(Activity context) {
            super(context, R.layout.spinnerlibro, libros);
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
                item = inflater.inflate(R.layout.spinnerlibro, null);

                holder = new ViewHolder();
                holder.nombre = (TextView) item.findViewById(R.id.campoNombre);
                holder.genero = (TextView) item.findViewById(R.id.campoGenero);
                holder.genero = (TextView) item.findViewById(R.id.campoPaginas);
                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }
            holder.nombre.setText(libros[position].getTitulo());
            holder.genero.setText(libros[position].getGenero());
            holder.paginas.setText(libros[position].getPaginas());
            return (item);

        }

    }
}