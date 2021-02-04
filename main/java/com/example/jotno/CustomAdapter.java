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

    ArrayList<Tutor> tutor;
    Context context;

    CustomAdapter(Context context, ArrayList<Tutor>tutor)
    {
        this.context=context;
        this.tutor=tutor;


    }


    public int getCount() {
        return tutor.size();
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
        TextView department=(TextView) view.findViewById(R.id.mottos);
        TextView institute=(TextView)view.findViewById(R.id.institute);
        String name=tutor.get(i).getName();
        String tinstitue=tutor.get(i).getInstitute();
        String tdepartment=tutor.get(i).getDepartment();



        namess.setText(name);
        department.setText(tdepartment);
        institute.setText(tinstitue);


        //imageView.setImageResource(imgs[i]);


        return view;
    }
}
