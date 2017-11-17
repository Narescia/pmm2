package com.example.anaval.examenanatorres;

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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

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

            Button total = (Button) findViewById(R.id.total);
            final RadioGroup tiposenvio = (RadioGroup) findViewById(R.id.tiposenvios);
            final EditText unidades = (EditText) findViewById(R.id.unidades);
            final Button local = (Button)findViewById(R.id.local);
            final Button domicilio = (Button)findViewById(R.id.domicilio);
            final CheckBox queso = (CheckBox) findViewById(R.id.queso);
            final CheckBox ingred = (CheckBox) findViewById(R.id.ingred);
            final CheckBox grande = (CheckBox) findViewById(R.id.grande);

            total.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent paso = new Intent(MainActivity.this, Resultado.class);

                    Bundle pasoobjetos = new Bundle();

                    double preciopizza = datos[pizzas.getSelectedItemPosition()].getPrecio();
                    Pizza pizza = new Pizza(datos[pizzas.getSelectedItemPosition()].getNombre(),
                            datos[pizzas.getSelectedItemPosition()].getDescripcion(),
                            datos[pizzas.getSelectedItemPosition()].getPrecio(),datos[pizzas.getSelectedItemPosition()].getImagen());
                    pasoobjetos.putSerializable("pizza", (Serializable) pizza);
                    paso.putExtras(pasoobjetos);

                    double preciounidades = 0;
                    if (unidades.getText().toString().isEmpty()) {
                        unidades.setText("0");
                    }
                    if (Double.parseDouble(unidades.getText().toString()) < 6) {
                        preciopizza = Double.parseDouble(unidades.getText().toString()) * 1;
                    }
                    if (Double.parseDouble(unidades.getText().toString()) >= 6 && Double.parseDouble
                            (unidades.getText().toString()) < 10) {
                        preciopizza = Double.parseDouble(unidades.getText().toString()) * 1.5;
                    }
                    if (Double.parseDouble(unidades.getText().toString()) >= 10) {
                        preciopizza = Double.parseDouble(unidades.getText().toString()) * 2;
                    }
                    paso.putExtra("unidades", unidades.getText().toString());
                    paso.putExtra("preciopizza", String.valueOf(preciopizza));
                    double total = preciopizza + preciounidades;

                    double envio = 0;
                    String nenvio= " ";
                    if (tiposenvio.getCheckedRadioButtonId() == R.id.local) {
                        nenvio = local.getText().toString();
                        envio = (total * 30) / 100;
                        nenvio = local.getText().toString();
                    }
                    if (tiposenvio.getCheckedRadioButtonId() == R.id.domicilio) {
                        nenvio = domicilio.getText().toString();
                        envio = 0;
                        nenvio = domicilio.getText().toString();
                    }
                    paso.putExtra("Tipo envío", nenvio);
                    paso.putExtra("Envío", String.valueOf(envio));
                    total = total + envio;
                    paso.putExtra("total", String.valueOf(total));

                    boolean checked = false;
                    if (grande.isChecked()) {
                        checked = true;
                        paso.putExtra("Grande", grande.getText().toString());
                        paso.putExtra("checked", checked);
                    }
                    if (queso.isChecked()) {
                        checked = true;
                        paso.putExtra("Extra queso", queso.getText().toString());
                        paso.putExtra("checked2", checked);
                    }
                    if (ingred.isChecked()) {
                        checked = true;
                        paso.putExtra("Extra ingrediente", ingred.getText().toString());
                        paso.putExtra("checked3", checked);
                    }
                    startActivity(paso);
                }
            });

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
                return (item);

            }
        }

    }

