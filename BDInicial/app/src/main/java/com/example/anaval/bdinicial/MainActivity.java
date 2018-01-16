package com.example.anaval.bdinicial;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Cliente [] clientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Abrimos la base de datos en modo escritura
        ClienteSQLiteHelper cliBDh = new ClienteSQLiteHelper(this, "DBClientes", null, 1);
        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();
//        if (bd != null) {        //Si correcta la base de datos
//            for (int cont = 1; cont <= 3; cont++) {  //Introducimos 3 clientes de ejemplo
//                int codigo = cont;
//                String nombre = "cli" + cont;
//                String telefono = cont + "XXXXXXX";
//                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
//                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
//            }
//        }
        String[] campos = new String[] {"nombre", "telefono"};

        Cursor c = bd.query("Clientes", campos, null, null, null, null, null);
        clientes = new Cliente[c.getCount()];
        int i = 0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String nombreCli = c.getString(0);
                String telefonoCli = c.getString(1);
                clientes[i]= new Cliente(nombreCli, telefonoCli);
                i++;
            } while (c.moveToNext());
        }
        bd.close();

        AdaptadorBd adaptador = new AdaptadorBd(this);
        final Spinner spiclientes = (Spinner) findViewById(R.id.spclientes);
        spiclientes.setAdapter(adaptador);

        spiclientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String mensaje = "Nombre: " + clientes[i].getNombre() + " Telefono: " + clientes[i].getTelefono();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

       //bd.execSQL("INSERT INTO Clientes (nombre, telefono) VALUES ('cli1','11111') ");
//
//        bd.execSQL("UPDATE Clientes SET telefono='00000' WHERE nombre='cli1' ");
//
//        bd.execSQL("DELETE FROM Clientes WHERE nombre='cli1' ");

        //Ejemplo de utilización del método insert()
        //Creamos el registro que queremos insertar utilizando un objeto ContentValues
//        ContentValues nuevoRegistro = new ContentValues();
//        nuevoRegistro.put("nombre","cli10");
//        nuevoRegistro.put("telefono", "101010");
        //Insertamos el registro en la base de datos
        //El primer parámetro es el nombre de la tabla donde insertaremos.
        //El segundo parámetro solo sirve en caso de introducir un registro vacio
        //El tercer paráemtro es el objeto ContentValues que contiene el registro a insertar
//        bd.insert("Clientes", null, nuevoRegistro);

        //Ejemplo de utilización del método update()
        //Establecemos los campos-valores que vamos a actualizar
//        ContentValues valores = new ContentValues();
//        valores.put("telefono", "101010XX");
        //Actualizamos el registro en la base de datos
        //El tercer argumento es la condición del UPDATE tal como lo haríamos en la cláusula
        //WHERE en una sentencia SQL normal.
        //El cuarto argumento son partes variables de la sentencia SQL que aportamos en un
        //vector de valores aparte
//        String[] args = new String[]{"cli1", "cli2"};
//        bd.update("Clientes", valores, "nombre=? OR nombre=?", args);

        //Ejemplo de utilización del método delete()
        //Eliminamos el registro del cliente 'cli2'
//        String[] args2 = new String[]{"cli2"};
//        bd.delete("Clientes", "nombre=?", args2);

    }

    class AdaptadorBd extends ArrayAdapter<Cliente> {
        Activity context;

        AdaptadorBd(Activity context) {
            super(context, R.layout.spinner_bd, clientes);
            this.context = context;
        }

        class ViewHolder {
            TextView nombre;
            TextView telefono;
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
                item = inflater.inflate(R.layout.spinner_bd, null);

                holder = new ViewHolder();
                holder.nombre = (TextView) item.findViewById(R.id.nombre);
                holder.telefono = (TextView) item.findViewById(R.id.telefono);
                item.setTag(holder);

            } else {
                holder = (ViewHolder) item.getTag();
            }
            holder.nombre.setText(clientes[position].getNombre());
            holder.telefono.setText(String.valueOf(clientes[position].getTelefono()));
            return (item);

        }
    }

}