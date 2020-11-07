package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class New_profile extends AppCompatActivity {

    TextView name;
    TextView sub;
    TextView loc;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);
        name =(TextView)findViewById(R.id.name);
        sub=(TextView)findViewById(R.id.subs);
        loc=(TextView)findViewById(R.id.loc);
        bundle=getIntent().getExtras();
        name.setText(bundle.getString("name"));
        sub.setText(bundle.getString("sub"));
        loc.setText("Your location is "+bundle.getString("loc"));





    }
}