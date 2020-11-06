package com.example.jotno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdaptar2 extends BaseAdapter {


    String[] locations_names;
    Context context;
    CustomAdaptar2(Context context,String[] location_names)
    {
        this.context=context;
        this.locations_names=location_names;
    }


    public int getCount() {
        return locations_names.length;
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
        if(view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.sample_view2, viewGroup, false);
        }

        TextView location_name=view.findViewById(R.id.sample_view2);
        location_name.setText(locations_names[i]);

return view;
    }
}
