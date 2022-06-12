package com.example.galicia;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador2 extends BaseAdapter {
    private Context context;
    ArrayList<MiVista> listaitems;
    ArrayList<MiVista> listaitemscopia;
    protected ArrayList<MiVista> copiaarray = new ArrayList<>();
    public Adaptador2(Context context, ArrayList<MiVista> listaitems){
        this.context = context;
        this.listaitems = listaitems;

        listaitemscopia = new ArrayList<>();
        listaitemscopia.addAll(listaitems);
    }

    @Override
    public int getCount(){ return listaitems.size();}

    @Override
    public Object getItem(int position){return  listaitems.get(position);}

    @Override
    public long getItemId(int position){return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final MiVista Item = (MiVista) getItem(position);

        // convertView which is recyclable view
     convertView = LayoutInflater.from(context).inflate(R.layout.itemlista, null);

        // get the position of the view from the ArrayAdapter

        // then according to the position of the view assign the desired image for the same
        ImageView numbersImage = convertView.findViewById(R.id.imagenLugo);

        numbersImage.setImageResource(Item.getImagen());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = convertView.findViewById(R.id.NombreLugo);
        textView1.setText(Item.getNombre());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = convertView.findViewById(R.id.lugarLugo);
        textView2.setText(Item.getLugar());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetallado.class);
                intent.putExtra("objetoData", Item);

                context.startActivity(intent);

            }
        });

        // then return the recyclable view
        return convertView;


    }
    public void filtrar(String texto) {

        // Elimina todos los datos del ArrayList que se cargan en los elementos del adaptador
        listaitems.clear();

        // Si no hay texto: agrega de nuevo los datos del ArrayList copiado
        // al ArrayList que se carga en los elementos del adaptador
        if (texto.length() == 0) {
            listaitems.addAll(copiaarray);
        } else {

            // Recorre todos los elementos que contiene el ArrayList copiado
            // y dependiendo de si estos contienen el texto ingresado por el
            // usuario los agrega de nuevo al ArrayList que se carga en los
            // elementos del adaptador.
            for (MiVista v : copiaarray) {

                if (v.getNombre().contains(texto)) {
                    listaitems.add(v);
                }
            }
        }

        // Actualiza el adaptador para aplicar los cambios
        notifyDataSetChanged();
    }

    public void filtrado(String cadena){
        int longitud = cadena.length();
      if (longitud==0){
            listaitems.clear();
          listaitems.addAll(listaitemscopia);
        }else{
     //     List<MiVista> coleccion = listaitems.stream().filter(i -> i.getNumberInDigit().toLowerCase().contains(cadena.toLowerCase())) .collect(Collectors.toList());
     //     listaitems.clear();
     //     listaitemscopia.addAll(coleccion);

          for   (MiVista m : listaitemscopia){
              if(m.getNombre().toLowerCase().contains(cadena.toLowerCase())){
                listaitems.add(m);
              }
          }

      }
      notifyDataSetChanged();
    }


}
