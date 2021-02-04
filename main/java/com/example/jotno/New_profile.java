package com.example.jotno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

public class New_profile extends AppCompatActivity implements View.OnClickListener {


   private TextView sub;
   private TextView loc;
   private Button update;
   private DatabaseReference databaseReference;
   private String email;
   private Tutor tutor;
   private ProgressBar progressBar;
   private int progressStatus=0;
   private Handler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);

        loc=(EditText)findViewById(R.id.location);
        update=(Button)findViewById(R.id.update);
        email=getIntent().getStringExtra("email");
        databaseReference= FirebaseDatabase.getInstance().getReference("Tutor information");
        progressBar=(ProgressBar)findViewById(R.id.loading);
        handler = new Handler();
        update.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.update:

                updateData(email,loc.getText().toString());


                break;
        }
    }

    void updateData(final String from, String to)
    {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean flag=false;
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Tutor tutor = dataSnapshot.getValue(Tutor.class);
                    if(tutor.getEmail().matches(from))
                    {
                        tutor.setLocation(loc.getText().toString());
                        String key=dataSnapshot.getKey();
                        databaseReference.child(key).setValue(tutor);
                        flag=true;
                        break;

                    }
                }
                if(flag) Toast.makeText(getApplicationContext(),"Location is Updated",Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(),"Data not found",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                   Toast.makeText(getApplicationContext(),"There was an error updating data",Toast.LENGTH_SHORT).show();
            }
        });


    }




}