package com.example.jotno;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Available_tutors extends AppCompatActivity {

    private ArrayList<Tutor> tutors=new ArrayList<Tutor>();
    private ListView listView;
    private CustomAdapter customAdapter;
    private DatabaseReference databaseReference ;
    private ProgressBar progressBar;
    private int progressStatus=0;
    private Handler handler;


    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_available_tutors);
        super.onCreate(savedInstanceState);
        listView=(ListView)findViewById(R.id.names);
        databaseReference=FirebaseDatabase.getInstance().getReference("Tutor information");

        handler = new Handler();

        onStart();



   }

    @Override
    protected void onStart() {




       databaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange( DataSnapshot snapshot) {
               tutors.clear();
           //   setContentView(R.layout.activity_data__loading__screen);
               for( DataSnapshot dataSnapshot: snapshot.getChildren() )
               {
                   Tutor tutor = dataSnapshot.getValue(Tutor.class);
                   tutors.add(tutor);
               }

           //    setContentView(R.layout.activity_available_tutors);
               customAdapter= new CustomAdapter(Available_tutors.this,tutors);
               listView.setAdapter(customAdapter);

               Toast.makeText(Available_tutors.this,"Your Tutors are here",Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {
                      Toast.makeText(Available_tutors.this,"Error occured",Toast.LENGTH_SHORT).show();
           }
       });

        super.onStart();
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