package com.example.galicia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Coruna extends AppCompatActivity implements Serializable {

    AutoCompleteTextView campoC;
    protected ArrayList<MiVista> arrayCoru ;
    ListView numbersListView;
    Adaptador2 numbersArrayAdapter;
    ArrayAdapter<MiVista> adapt;
    String nombres[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coruna);


        campoC = findViewById(R.id.campoC);



        campoC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                numbersArrayAdapter.filtrar(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        numbersListView = (ListView) findViewById(R.id.listaCoru);
        arrayCoru = GetArrayItems();
        numbersArrayAdapter = new Adaptador2(this, arrayCoru);
        numbersListView.setAdapter(numbersArrayAdapter);


        //menu
        registerForContextMenu(findViewById(R.id.tvmenuC));
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
                findViewById(R.id.campoC).setVisibility(View.VISIBLE);

                return true;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }











    }


    // Método para rellenar el array de lugares de Coruna.
    private ArrayList<MiVista> GetArrayItems(){
        ArrayList<MiVista> listaitems = new ArrayList<>();
        listaitems.add(new MiVista(R.drawable.catedral_santiago, "Catedral de Santiago", "Santiago de Compostela"));
        listaitems.add(new MiVista(R.drawable.torre_hercules, "Torre de Hércules", "A Coruña"));
        listaitems.add(new MiVista(R.drawable.costa_morte, "A Costa da Morte", ""));
        return listaitems;
    }
}