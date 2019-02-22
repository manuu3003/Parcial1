package com.example.parcial1;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CancionAdapter extends ArrayAdapter<Cancion> {
    private Context context;
    private List<Cancion> list;

    public CancionAdapter(@NonNull Context context, @NonNull List<Cancion> objects) {
        super(context, R.layout.item_list_canciones, objects);
        this.context = context;
        this.list = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item_list_canciones, null);
        }
        if (list.get(position) != null) {
            TextView nombre, version;
            LinearLayout fondo;
            ImageView imagen;
            fondo = v.findViewById(R.id.lyt_fondo);
            nombre = v.findViewById(R.id.tv_nombre);
            version = v.findViewById(R.id.tv_version);
            imagen = v.findViewById(R.id.img_tipo);
            nombre.setText(list.get(position).getNombre());
            version.setText(list.get(position).getversion());
            imagen.setImageResource(list.get(position).getImagen());

            if (list.get(position).getTipo()== 1) {
                imagen.setImageResource(R.drawable.rock);
            } else if (list.get(position).getTipo()== 2) {
                imagen.setImageResource(R.drawable.pop);
            } else {
                imagen.setImageResource(R.drawable.reggaeton);
            }

            if (list.get(position).getversion()== "En vivo") {
                version.setText("En Vivo");
                fondo.setBackgroundColor(Color.parseColor("#1967e5"));
            } else if (list.get(position).getversion()== "Especial") {
                version.setText("Especial");
                fondo.setBackgroundColor(Color.parseColor("#a118e5"));
            } else {
                version.setText("Normal");
                fondo.setBackgroundColor(Color.parseColor("#74e518"));
            }


        }
        return  v;
    }




}
