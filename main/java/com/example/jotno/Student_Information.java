package com.example.jotno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Student_Information extends AppCompatActivity implements View.OnClickListener {

    private EditText student_name;
    private EditText student_phone;
    private String tutor_email;
    private DatabaseReference databaseReference;
    private Button send_request;
    private ProgressBar progressBar;
    private Handler handler;
    private int progressStatus=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__information);

        handler=new Handler();
        progressBar=(ProgressBar)findViewById(R.id.loading);
        tutor_email=getIntent().getStringExtra("tutor_email");
        student_name=(EditText)findViewById(R.id.student_name);
        student_phone=(EditText)findViewById(R.id.student_phone);
        databaseReference= FirebaseDatabase.getInstance().getReference("Student Information");
        send_request=(Button)findViewById(R.id.send_request);
        send_request.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.send_request:

                if(student_name.getText().toString().matches("")||student_phone.getText().toString().matches(""))
                {
                    Toast.makeText(getApplicationContext(),"Please provide valid information",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Requester requester = new Requester(student_name.getText().toString(),student_phone.getText().toString(),tutor_email);

                    set_Request(requester);


                }


                break;
        }
    }

    private void set_Request(Requester requester)
    {

        runProgressbar();
       progressBar.setVisibility(View.VISIBLE);
       String key=databaseReference.push().getKey();
       databaseReference.child(key).setValue(requester);
       progressBar.setVisibility(View.INVISIBLE);
       Toast.makeText(getApplicationContext(),"Request Sent",Toast.LENGTH_SHORT).show();
        finish();

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