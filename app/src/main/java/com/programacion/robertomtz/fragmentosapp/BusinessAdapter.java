package com.programacion.robertomtz.fragmentosapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by rmartinezm on 10/04/2017.
 */

public class BusinessAdapter extends BaseAdapter {

    private ArrayList<Negocio> negocios;
    private Context context;

    public BusinessAdapter(ArrayList<Negocio> negocios, Context context){
        this.negocios = negocios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return negocios.size();
    }

    @Override
    public Object getItem(int position) {
        return negocios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.adapter_business, null);

        Negocio negocio = negocios.get(position);

        final int posicion = position;

        TextView textView = (TextView) v.findViewById(R.id.business_tv_name);
        textView.setText(negocio.getNombre());
        ImageView iv = (ImageView) v.findViewById(R.id.business_iv_image);
        Button btn = (Button) v.findViewById(R.id.business_button_map);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra("negocio", negocios.get(posicion));
                context.startActivity(intent);
            }
        });

        if (!negocio.getImagen().isEmpty())
                Glide.with(context)
                .load(negocio.getImagen())
                .crossFade()
                .into(iv);

        return v;
    }
}
