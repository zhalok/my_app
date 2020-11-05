package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.jotno.R.id.names;

public class available_tutors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_tutors);
        ListView names=(ListView) findViewById(R.id.names);
        String[] tutors=getResources().getStringArray(R.array.tutor_names);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(available_tutors.this,R.layout.sample_view,R.id.sample_view,tutors);
        names.setAdapter(adapter);

    }
}