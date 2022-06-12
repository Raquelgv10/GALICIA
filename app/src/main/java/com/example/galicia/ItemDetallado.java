package com.example.galicia;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetallado extends AppCompatActivity   {
    private MiVista Item;
    private TextView nombreSitio, descripcionSitio;
    private ImageView fotoSitio;


     @Override
     public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdetallado);


        Item = (MiVista) getIntent().getSerializableExtra("objetoData");

        nombreSitio = (TextView) findViewById(R.id.NombreSitio);
        descripcionSitio = (TextView) findViewById(R.id.DescripcionSitio);
        fotoSitio = (ImageView) findViewById(R.id.ImagenSitio);

        nombreSitio.setText(Item.getNombre());
        descripcionSitio.setText(Item.getLugar());
        fotoSitio.setImageResource(Item.getImagen());






     }
}


