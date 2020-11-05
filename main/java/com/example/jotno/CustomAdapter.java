package com.example.jotno;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    String[] names,mottos;
    Context context;
    int[] imgs;
    CustomAdapter(Context context,String[] names,String[] mottos,int[] imgs)
    {
        this.context=context;
        this.names=names;
        this.mottos=mottos;
        this.imgs=imgs;
    }


    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null)
        {
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.sample_view,viewGroup,false);
        }

        TextView namess=(TextView) view.findViewById(R.id.sample_view);
        TextView mt=(TextView) view.findViewById(R.id.mottos);
        ImageView imageView=(ImageView) view.findViewById(R.id.dp);
        namess.setText(names[i]);
        mt.setText(mottos[i]);
        imageView.setImageResource(imgs[i]);


        return view;
    }
}
