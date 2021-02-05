package com.example.jotno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Requests extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Requester> requesters;
    private DatabaseReference databaseReference;
    private CustomAdapter3 customAdapter3;
    private String tutor_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        listView=(ListView)findViewById(R.id.requests);
        databaseReference= FirebaseDatabase.getInstance().getReference("Student Information");
        tutor_email=getIntent().getStringExtra("tutor_email");
        requesters=new ArrayList<Requester>();
        getData();
        if(requesters.size()==0) {
            Toast.makeText(getApplicationContext(),"No requests right now",Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            customAdapter3 = new CustomAdapter3(Requests.this, requesters);

            listView.setAdapter(customAdapter3);
        }

    }

    private void getData()
    {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Requester requester = dataSnapshot.getValue(Requester.class);

                       requesters.add(requester);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}