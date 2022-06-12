package com.example.galicia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class MiAdaptador extends ArrayAdapter<MiVista> {

    public MiAdaptador(@NonNull Context context, ArrayList<MiVista> arrayList) {

        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {

        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.itemlista, parent, false);
        }

        MiVista currentNumberPosition = getItem(position);


        ImageView numbersImage = currentItemView.findViewById(R.id.imagenLugo);
        assert currentNumberPosition != null;
        numbersImage.setImageResource(currentNumberPosition.getImagen());


        TextView textView1 = currentItemView.findViewById(R.id.NombreLugo);
        textView1.setText(currentNumberPosition.getNombre());


        TextView textView2 = currentItemView.findViewById(R.id.lugarLugo);
        textView2.setText(currentNumberPosition.getLugar());

        return currentItemView;
    }



}