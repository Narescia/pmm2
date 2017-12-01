package com.example.anaval.recopilatorio;

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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private Destino[] datos = new Destino[]{
            new Destino("Zona A:", "Asia y Oceanía: ", 30),
            new Destino("Zona B:", "América y África", 20),
            new Destino ("Zona C: ", "Europa", 10)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorDestino adaptador = new AdaptadorDestino(this);
        final Spinner zonas = (Spinner) findViewById(R.id.zonas);
        zonas.setAdapter(adaptador);

        Button calcular = (Button)findViewById(R.id.calcular);
        final RadioGroup tarifas = (RadioGroup)findViewById(R.id.tarifas);
        final Button urgente = (Button)findViewById(R.id.urgente);
        final Button normal = (Button)findViewById(R.id.normal);
        final EditText peso = (EditText)findViewById(R.id.peso);
        final CheckBox caja = (CheckBox)findViewById(R.id.regalo);
        final CheckBox tarjeta = (CheckBox)findViewById(R.id.tarjeta);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paso = new Intent(MainActivity.this, Factura.class);

                Bundle pasoobjetos = new Bundle();
                //Precio de la zona y pasar el objeto
                double preciozona = datos[zonas.getSelectedItemPosition()].getPrecio();
                Destino destino = new Destino (datos[zonas.getSelectedItemPosition()].getZona(),
                        datos[zonas.getSelectedItemPosition()].getContinente(),
                        datos[zonas.getSelectedItemPosition()].getPrecio());
                pasoobjetos.putSerializable("destino", (Serializable) destino);
                paso.putExtras(pasoobjetos);

                double preciopeso = 0;
                if (peso.getText().toString().isEmpty()){
                    peso.setText("0");
                }
                if (Double.parseDouble(peso.getText().toString()) < 6){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 1;
                }
                if (Double.parseDouble(peso.getText().toString()) >= 6 && Double.parseDouble(peso.getText().toString()) < 10){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 1.5;
                }
                if (Double.parseDouble(peso.getText().toString()) >= 10){
                    preciopeso = Double.parseDouble(peso.getText().toString()) * 2;
                }
                paso.putExtra("peso", peso.getText().toString());
                paso.putExtra("preciopeso", String.valueOf(preciopeso));
                double total =  preciozona + preciopeso;

                //Precio de tarifa y pasarlo
                double tarifa = 0;
                String ntarifa = " ";
                if (tarifas.getCheckedRadioButtonId() == R.id.urgente){
                    ntarifa = urgente.getText().toString();
                    tarifa = (total * 30 ) / 100;
                    ntarifa = urgente.getText().toString();
                }
                if (tarifas.getCheckedRadioButtonId() == R.id.normal){
                    ntarifa = normal.getText().toString();
                    tarifa = 0;
                    ntarifa = normal.getText().toString();
                }
                paso.putExtra("nombretarifa", ntarifa);
                paso.putExtra("tarifa", String.valueOf(tarifa));
                total = total + tarifa;
                paso.putExtra("total", String.valueOf(total));

                //Tipo de envoltorio
                boolean checked = false;
                if(caja.isChecked()){
                    checked = true;
                    paso.putExtra("cajaregalo", caja.getText().toString());
                    paso.putExtra("checked", checked);
                }
                if(tarjeta.isChecked()){
                    checked = true;
                    paso.putExtra("tarjeta", tarjeta.getText().toString());
                    paso.putExtra("checked2", checked);
                }
                startActivity(paso);

            }
        });

    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
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

    static class ViewHolder {
        TextView zona;
        TextView continente;
        TextView precio;
    }

    class AdaptadorDestino extends ArrayAdapter<Destino> {
        Activity context;

        AdaptadorDestino(Activity context) {
            super(context, R.layout.spinnerdestino, datos);
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
                item = inflater.inflate(R.layout.spinnerdestino, null);

                holder = new ViewHolder();
                holder.zona = (TextView) item.findViewById(R.id.zona);
                holder.continente = (TextView) item.findViewById(R.id.continente);
                holder.precio = (TextView) item.findViewById(R.id.precio);
                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }
            holder.zona.setText(datos[position].getZona());
            holder.continente.setText(datos[position].getContinente());
            holder.precio.setText(datos[position].getPrecio());
            return (item);

        }

    }
}
