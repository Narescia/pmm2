package com.example.anaval.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView lblMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblMensaje = (TextView)findViewById(R.id.lblMensaje);

        registerForContextMenu(lblMensaje);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                //lblMensaje.setText("Opcion 1 pulsada!");
                Toast.makeText(MainActivity.this, "Seleccionado desarrollo", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada!");
                return true;
            case R.id. SubMnuOpc1:
                lblMensaje.setText("Submenu: Opcion 1!");
                return true;
            case R.id. SubMnuOpc2:
                lblMensaje.setText ("Submenu: Opcion 2!"); ;
                return true;

            case R.id.MnuOpc3:
                lblMensaje.setText("Acerca De");
                return true;

            case R.id.CtxLblOpc1:
                lblMensaje.setText("Contextual: Opcion 1 pulsada!");
                return true;
            case R.id.CtxLblOpc2:
                lblMensaje.setText("Contextual: Opcion 2 pulsada!");
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }




}
