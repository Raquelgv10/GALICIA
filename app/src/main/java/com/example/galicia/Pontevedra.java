package com.example.galicia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pontevedra extends AppCompatActivity {
    protected ArrayList<MiVista> arrayPonte;
    ListView listview;
    Adaptador2 adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontevedra);


        listview = (ListView) findViewById(R.id.listaPonte);
        arrayPonte = GetArrayItems();
        adaptador = new Adaptador2(this, arrayPonte);
        listview.setAdapter(adaptador);

        //menu
        registerForContextMenu(findViewById(R.id.tvmenuP));//para que el menu contextual etÃ© asocuado con el
    }

    //Menu contextual --> mantener pulsado
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2:
                Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();

                return true;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); //inflar -> cuando la poner a la vista
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu); // o return true;
    }

    //menu de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2:
                Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
                findViewById(R.id.busquedaP).setVisibility(View.VISIBLE);
                return true;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }


    }


    private ArrayList<MiVista> GetArrayItems(){
        ArrayList<MiVista> listaitems = new ArrayList<>();
        listaitems.add(new MiVista(R.drawable.cabo_home, "Cabo home", "Cangas"));
        listaitems.add(new MiVista(R.drawable.illas_cies, "Islas Cíes", ""));
        listaitems.add(new MiVista(R.drawable.playa_samil, "Playa de Samil", "Vigo"));
        listaitems.add(new MiVista(R.drawable.castro_santa_tecla, "Castro de Santa Trega", "La Guardia"));
        listaitems.add(new MiVista(R.drawable.poza_moura, "Poza da Moura", "Domaio"));
        return listaitems;
    }


}