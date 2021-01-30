package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

import static com.example.jotno.R.id.mottos;
import static com.example.jotno.R.id.names;

public class Available_tutors extends AppCompatActivity {


   ArrayList<String> tutors;
   ArrayList<String> locations;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tutors= getIntent().getStringArrayListExtra("names");
        locations=getIntent().getStringArrayListExtra("locations");



        setContentView(R.layout.activity_available_tutors);
        ListView names=(ListView) findViewById(R.id.names);

        CustomAdapter adapter= new CustomAdapter(this,tutors,locations);
        names.setAdapter(adapter);
        names.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}