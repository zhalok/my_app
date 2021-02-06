package com.example.jotno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<Tutor> tutors;
    Context context;

    CustomAdapter(Context context, ArrayList<Tutor>tutors)
    {
        this.context=context;
        this.tutors=tutors;


    }


    public int getCount() {
        return tutors.size();
    }

    @Override
    public Tutor getItem(int i) {

     return tutors.get((i));
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
        String name=tutors.get(i).getName();
        String tinstitue=tutors.get(i).getInstitute();
        String tdepartment=tutors.get(i).getDepartment();



        namess.setText(name);
        department.setText(tdepartment);
        institute.setText(tinstitue);


        //imageView.setImageResource(imgs[i]);


        return view;
    }
}
