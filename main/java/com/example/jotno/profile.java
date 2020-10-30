package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       TextView textView=(TextView)findViewById(R.id.txt);
        final EditText sun= (EditText)findViewById(R.id.name);
        Button match=(Button)findViewById(R.id.match) ;

       Bundle bundle= getIntent().getExtras();
       if(bundle!=null)
       {
           final String name = bundle.getString("name");
           textView.setText(name);
           match.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(sun.getText().toString().matches(name))
                   {
                       Toast.makeText(profile.this,"matched",Toast.LENGTH_SHORT).show();
                   }
                   else {
                       Toast.makeText(profile.this,"not matchd",Toast.LENGTH_SHORT).show();
                   }
               }
           });

       }



    }
}