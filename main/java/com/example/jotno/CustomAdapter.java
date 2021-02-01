package com.example.jotno;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    ArrayList<String> names,locations;
    Context context;

    CustomAdapter(Context context, ArrayList<String>names, ArrayList<String>locations)
    {
        this.context=context;
        this.names=names;
        this.locations=locations;

    }


    public int getCount() {
        return names.size();
    }

    @Override
    public ArrayList<String> getItem(int i) {
        ArrayList<String> information = new ArrayList<String>();
        information.add(names.get(i));
        information.add(locations.get(i));
        return information;

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
        namess.setText(names.get(i));
        mt.setText(locations.get(i));

        //imageView.setImageResource(imgs[i]);


        return view;
    }
}
