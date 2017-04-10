package com.programacion.robertomtz.fragmentosapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rmartinezm on 10/04/2017.
 */

public class BussinesAdapter extends BaseAdapter {

    private ArrayList<Negocio> negocios;
    private Context context;

    public BussinesAdapter(ArrayList<Negocio> negocios, Context context){
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
        View v = inflater.inflate(R.layout.adapter_bussines, null);

        Negocio negocio = negocios.get(position);

        Button button = (Button) v.findViewById(R.id.bussines_button_map);
        TextView textView = (TextView) v.findViewById(R.id.bussines_tv_name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to map
            }
        });
        textView.setText(negocio.getNombre());

        return v;
    }
}
