package com.example.galicia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Botón que lleva a los concellos de la provincia de Pontevedra.
    public void ToPontevedra(View view) {
        Toast.makeText(this, "Pontevedra", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Pontevedra.class));
    }

    //Botón que lleva a los concellos de la provincia de Ourense.
    public void toOurense(View view) {
        Toast.makeText(this, "Ourense", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Ourense.class));
    }

    //Botón que lleva a los concellos de la provincia de A Coruna.
    public void toCoru(View view) {
        Toast.makeText(this, "A Coruña", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Coruna.class));
    }

    //Botón que lleva a los concellos de la provincia de Lugo.
    public void toLugo(View view)
    {
        Toast.makeText(this, "Lugo", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Lugo.class));
    }
}