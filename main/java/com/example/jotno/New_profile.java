package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class New_profile extends AppCompatActivity {

    TextView name;
    TextView sub;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);
        name =(TextView)findViewById(R.id.name);
        sub=(TextView)findViewById(R.id.subs);
        bundle=getIntent().getExtras();
        name.setText(bundle.getString("name"));
        sub.setText(bundle.getString("sub"));




    }
}