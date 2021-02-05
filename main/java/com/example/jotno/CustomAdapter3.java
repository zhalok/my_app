package com.example.jotno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter3 extends BaseAdapter {

    ArrayList<Requester>requesters;
    Context context;

     CustomAdapter3(Context context,ArrayList<Requester> requesters)
    {
        this.context=context;
        this.requesters=requesters;
    }


    @Override
    public int getCount() {
        return requesters.size();
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
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view=layoutInflater.inflate(R.layout.sample_view3,null);

        }

        TextView student_name=view.findViewById(R.id.student_name);
        TextView student_phone=view.findViewById(R.id.student_phone);
        student_name.setText(requesters.get(i).getName());
        student_phone.setText(requesters.get(i).getNumber());


        return view;
    }
}
