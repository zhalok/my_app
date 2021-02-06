package com.example.jotno;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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

public class Available_tutors extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Tutor> tutors=new ArrayList<Tutor>();
    private ListView listView;
    private CustomAdapter customAdapter;
    private DatabaseReference databaseReference ;
    private ProgressBar progressBar;
    private int progressStatus=0;
    private Handler handler;
    private EditText search;
    private Button search_button,reload_button;


    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_available_tutors);
        super.onCreate(savedInstanceState);
        listView=(ListView)findViewById(R.id.names);
        search=(EditText)findViewById(R.id.search_tutor);
        search_button=(Button)findViewById(R.id.s_button);
        reload_button=(Button)findViewById(R.id.reload_button);
        reload_button.setOnClickListener(this);
        databaseReference=FirebaseDatabase.getInstance().getReference("Tutor information");
        search_button.setOnClickListener(this);
        showData();

    }

    void showData()
    {
        databaseReference.addValueEventListener(new ValueEventListener() {


            public void onDataChange( DataSnapshot snapshot) {
                tutors.clear();
                //   setContentView(R.layout.activity_data__loading__screen);
                for( DataSnapshot dataSnapshot: snapshot.getChildren() )
                {
                    Tutor tutor = dataSnapshot.getValue(Tutor.class);
                    tutors.add(tutor);
                }

                //    setContentView(R.layout.activity_available_tutors);
                if(tutors.size()==0)
                {
                    Toast.makeText(getApplicationContext(),"There are no tutors available sorry",Toast.LENGTH_SHORT).show();
                    finish();

                }
                else {
                    customAdapter = new CustomAdapter(Available_tutors.this, tutors);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                               Tutor tutor = customAdapter.getItem(i);
                               Intent intent = new Intent(Available_tutors.this,Student_Information.class);
                               intent.putExtra("tutor_email",tutor.getEmail());
                               startActivity(intent);
                        }
                    });

                    Toast.makeText(Available_tutors.this, "Your Tutors are here", Toast.LENGTH_SHORT).show();
                }

            }


            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Available_tutors.this,"Error occured",Toast.LENGTH_SHORT).show();
            }
        });

    }

    void find_data(final String location)
    {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tutors.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Tutor tutor = dataSnapshot.getValue(Tutor.class);
                    if(tutor.getLocation().matches(location))
                    {
                        tutors.add(tutor);
                    }
                }
                if(tutors.size()==0)
                {
                    customAdapter = new CustomAdapter(Available_tutors.this, tutors);
                    listView.setAdapter(customAdapter);
                    Toast.makeText(getApplicationContext(),"No tutors are here",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Here are your tutors",Toast.LENGTH_SHORT).show();
                    customAdapter = new CustomAdapter(Available_tutors.this, tutors);
                    listView.setAdapter(customAdapter);

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
            case R.id.s_button:

                String searched_location=search.getText().toString();
                if(searched_location.matches(""))
                {
                    Toast.makeText(getApplicationContext(),"Please provide a loation",Toast.LENGTH_SHORT).show();
                }
                else {

                    find_data(searched_location);


                }

                break;

            case R.id.reload_button:
                showData();
                break;
        }
    }
}