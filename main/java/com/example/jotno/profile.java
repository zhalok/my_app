package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView textView=(TextView)findViewById(R.id.txt);
        Bundle bundle = new Bundle();
        String name=bundle.getBundle("name").toString();
        textView.setText(name);



    }
}