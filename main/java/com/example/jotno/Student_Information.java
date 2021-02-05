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
        databaseReference= FirebaseDatabase.getInstance().getReference("Tutor information");
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
                    Requester requester = new Requester(student_name.getText().toString(),student_phone.getText().toString());
                    runProgressbar();
                    set_Request(tutor_email,requester);


                }


                break;
        }
    }

    private void set_Request(final String tutor_email, final Requester requester)
    {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.VISIBLE);
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Tutor tutor =dataSnapshot.getValue(Tutor.class);
                    if(tutor.getEmail().matches(tutor_email))
                    {

                        String key=dataSnapshot.getKey();
                        databaseReference.child(key).setValue(tutor);
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(),"Request Sent Successfully",Toast.LENGTH_SHORT).show();
                        return ;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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