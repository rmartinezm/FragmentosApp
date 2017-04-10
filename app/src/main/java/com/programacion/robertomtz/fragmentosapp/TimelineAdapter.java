package com.programacion.robertomtz.fragmentosapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rmartinezm on 10/04/2017.
 */

public class TimelineAdapter extends BaseAdapter {

    private ArrayList<Historia> list;
    private Context context;

    public TimelineAdapter(ArrayList<Historia> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.adapter_timeline, null);

        Historia historia = list.get(position);

        TextView user = (TextView) v.findViewById(R.id.timeline_tv_user);
        TextView text = (TextView) v.findViewById(R.id.timeline_tv_text);
        TextView title= (TextView) v.findViewById(R.id.timeline_tv_title);

        user.setText(historia.getUser() +  " ");
        text.setText(historia.getText() +  " ");
        title.setText(historia.getTitle() +  " ");

        return v;
    }
}
