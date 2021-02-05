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

import java.util.ArrayList;

 public class Tutor_profile extends AppCompatActivity implements View.OnClickListener {


     private TextView name;
     private TextView institute;
     private TextView department;
     private DatabaseReference databaseReference,databaseReference1;
     private String tutor_email;
     private Button view_requests;
     private ProgressBar progressBar;
     private Handler handler;
     private int progressStatus=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_profile);
        Toast.makeText(getApplicationContext(),tutor_email,Toast.LENGTH_SHORT).show();
        tutor_email=getIntent().getStringExtra("email");
        databaseReference = FirebaseDatabase.getInstance().getReference("Tutor information");
        name=(TextView)findViewById(R.id.tutor_name);
        institute=(TextView)findViewById(R.id.tutor_institute);
        department=(TextView)findViewById(R.id.tutor_department);
        view_requests=(Button)findViewById(R.id.view_requests);
        view_requests.setOnClickListener(this);
        progressBar=(ProgressBar)findViewById(R.id.loading);
        handler=new Handler();
        getData();


    }


   private void getData()
    {
           databaseReference.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot snapshot) {
                   for(DataSnapshot dataSnapshot:snapshot.getChildren())
                   {
                       Tutor tutor=dataSnapshot.getValue(Tutor.class);
                       if(tutor.getEmail().matches(tutor_email))
                       {
                           progressBar.setVisibility(View.INVISIBLE);
                           name.setText(tutor.getName());
                           institute.setText(tutor.getInstitute());
                           department.setText(tutor.getDepartment());
                           return ;
                       }
                   }
               }

               @Override
               public void onCancelled(@NonNull DatabaseError error) {

               }
           });
    }

     @Override
     public void onClick(View view) {
         switch (view.getId())
         {
             case R.id.view_requests:

                 Intent intent = new Intent(Tutor_profile.this,Requests.class);
                 intent.putExtra("tutor_email",tutor_email);
                 startActivity(intent);

                 break;
         }
     }

     public void runProgressbar()
     {
         new Thread(new Runnable() {
             public void run() {

                 while (progressStatus < 10000) {
                     progressStatus += 4;
                     //Update progress bar with completion of operation
                     handler.post(new Runnable() {
                         public void run() {
                             progressBar.setProgress(progressStatus);
                         }
                     });
                     try {
                         // Sleep for 300 milliseconds.
                         //Just to display the progress slowly
                         Thread.sleep(300);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }).start();
     }
 }