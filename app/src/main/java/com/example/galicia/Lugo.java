package com.example.galicia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lugo extends AppCompatActivity {
    protected ArrayList<MiVista> arrayLugo;
    ListView listview;
    Adaptador2 adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugo);



        listview = (ListView) findViewById(R.id.listaLugo);
        arrayLugo = GetArrayItems();
        adaptador = new Adaptador2(this, arrayLugo);
        listview.setAdapter(adaptador);




        //menu
        registerForContextMenu(findViewById(R.id.tvmenuL));//para que el menu contextual etÃ© asocuado con el
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
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
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
                findViewById(R.id.busquedaL).setVisibility(View.VISIBLE);
                return true;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }




    }


    private ArrayList<MiVista> GetArrayItems(){
        ArrayList<MiVista> listaitems = new ArrayList<>();
        listaitems.add(new MiVista(R.drawable.playa_catedrais, "Playa de las Catedrales", "Ribadeo"));
        listaitems.add(new MiVista(R.drawable.muralla_lug, "Muralla de Lugo", "Lugo"));

        return listaitems;
    }


}