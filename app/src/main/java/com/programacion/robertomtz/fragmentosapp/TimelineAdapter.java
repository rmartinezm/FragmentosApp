package com.programacion.robertomtz.fragmentosapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
        ImageView iv = (ImageView) v.findViewById(R.id.timeline_image);


        user.setText(historia.getUser() +  " ");
        text.setText(historia.getText() +  " ");
        title.setText(historia.getTitle() +  " ");

        /**
        Bitmap bm = getBitmapFromURL(historia.getImage());
        if (bm != null)
            iv.setImageBitmap(bm);
        **/

        return v;
    }

    /** Arroja NetworkOnMainThreadException connection.connect()

    public Bitmap getBitmapFromURL(String src) {
        try {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
     **/
}
