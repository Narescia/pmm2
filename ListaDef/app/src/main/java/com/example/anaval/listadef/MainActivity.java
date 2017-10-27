package com.example.anaval.listadef;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Perro[] datos = new Perro[]{
            new Perro("Whisky", "Beagle", R.drawable.imagen1),
            new Perro("Luna", "Golden Retriever", R.drawable.imagen2),
            new Perro("Robby", "Husky", R.drawable.imagen3)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorMascotas adaptador = new AdaptadorMascotas(this);
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);


        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int position, long id){
                String mensaje = "Título: " + datos[position].getTitulo() + "Subtitulo: " + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

                //Perro perro = new Perro (datos[position].getTitulo(), datos[position].getSubtitulo(), datos[position].getImagen());
                Perro perro = datos[position];
                Intent mIntent = new Intent(MainActivity.this,Pantalla2.class);
                Bundle miBundle = new Bundle();
                miBundle.putSerializable("clave", perro);
                mIntent.putExtras(miBundle);

                startActivity(mIntent);
            }


            public void onNothingSelected(AdapterView<?>adapterView){

            }
        });
    } //onCreate



    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
    }

    class AdaptadorMascotas extends ArrayAdapter{
        Activity context;

        AdaptadorMascotas(Activity context){
            super(context, R.layout.listperros, datos);
            this.context = context;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int i, View convertView, ViewGroup parent){

            View item = convertView;
            ViewHolder holder;
            if(item == null)
            { LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listperros, null);

                holder = new ViewHolder();
                holder.titulo = (TextView)item.findViewById(R.id.tvTitulo);
                holder.subtitulo = (TextView)item.findViewById(R.id.tvSubtitulo);
                ImageView imagen = (ImageView) item.findViewById(R.id.ivImagen);
                imagen.setBackground(getDrawable(datos[i].getImagen()));
                item.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)item.getTag(); }
            holder.titulo.setText(datos[i].getTitulo());
            holder.subtitulo.setText(datos[i].getSubtitulo());
            return(item);

        }
    }
}
