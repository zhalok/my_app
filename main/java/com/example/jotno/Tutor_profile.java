 package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

 public class Tutor_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_profile);
        String Name=getIntent().getStringExtra("name");
        String Location= getIntent().getStringExtra("location");
        TextView Tutor_name=(TextView)findViewById(R.id.tutor_name);
        TextView Tutor_location=(TextView)findViewById(R.id.Tutor_location);
        Tutor_name.setText(Name);
        Tutor_location.setText(Location);
    }
}