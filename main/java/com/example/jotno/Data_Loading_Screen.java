package com.example.jotno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Vector;

public class Data_Loading_Screen extends AppCompatActivity {

   private ProgressBar progressBar ;
   private int progressStatus=0;
   private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__loading__screen);
        progressBar=(ProgressBar)findViewById(R.id.loading);
        progressBar.setVisibility(View.VISIBLE);
        handler=new Handler();
        runProgressbar();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                    Intent intent = new Intent(getApplicationContext(),Available_tutors.class);
                    startActivity(intent);
                    finish();


                }catch (Exception e)
                {

                }


            }
        });
        thread.start();


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