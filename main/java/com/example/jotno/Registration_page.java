package com.example.jotno;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration_page extends AppCompatActivity {

   private Button next,load,store;
   private RadioGroup gender;
   private CheckBox math,phy,chem,ict;
   private EditText firstname,lastname,age;
   private RadioButton male,female;
   private Spinner locations;
   private String[] location_names;
   private EditText username,password;
   private Database database ;
   private FirebaseAuth mAuth;
   private ProgressBar progressBar;
   private int progressStatus=0;
   private Handler handler;
   private DatabaseReference databaseReference;


 //   TextView lastsavedinfo;
    boolean flag=false;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);


        handler = new Handler();
        progressBar = (ProgressBar)findViewById(R.id.load);
        next=(Button)findViewById(R.id.next);
        //store=(Button)findViewById(R.id.store);
        username=(EditText)findViewById((R.id.username));
        password=(EditText)findViewById((R.id.password));
        gender=(RadioGroup)findViewById(R.id.gender);
        firstname=(EditText)findViewById(R.id.fname);
        lastname=(EditText)findViewById(R.id.lname);
        age=(EditText)findViewById(R.id.age);
        male=(RadioButton)findViewById(gender.getCheckedRadioButtonId());
        female=(RadioButton)findViewById(gender.getCheckedRadioButtonId());
        math=(CheckBox)findViewById(R.id.math);
        phy=(CheckBox)findViewById(R.id.phy);
        chem=(CheckBox)findViewById(R.id.chem);
        ict=(CheckBox)findViewById(R.id.ict);
        locations=(Spinner)findViewById(R.id.locations);
        location_names=getResources().getStringArray(R.array.location_names);
        CustomAdaptar2 adaptar2= new CustomAdaptar2(this,location_names);
        locations.setAdapter(adaptar2);
        mAuth=FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         if(firstname.getText().toString().matches("")||lastname.getText().toString().matches("")||age.getText().toString().matches(""))
             Toast.makeText(Registration_page.this,"please provide ur information",Toast.LENGTH_SHORT).show();
         else
         {
             if(gender.getCheckedRadioButtonId()!=-1)
             {


                if(math.isChecked()||chem.isChecked()||phy.isChecked()||ict.isChecked())
                {

                    progressBar.setVisibility(View.VISIBLE);
                    runProgressbar();
                    StringBuilder name = new StringBuilder() ;
                    StringBuilder location = new StringBuilder();
                    StringBuilder subjects = new StringBuilder();
                    name.append(firstname.getText().toString()+" ");
                    name.append(lastname.getText().toString());
                    location.append(locations.getSelectedItem().toString());

                    if(math.isChecked()) subjects.append(math.getText().toString()+"\n");
                    if(phy.isChecked()) subjects.append(phy.getText().toString()+"\n");
                    if(chem.isChecked()) subjects.append(chem.getText().toString()+"\n");
                    if(ict.isChecked()) subjects.append(ict.getText().toString()+"\n");

                    final Tutor tutor = new Tutor(name.toString(),age.getText().toString(),location.toString(),subjects.toString());

                    mAuth.createUserWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                            .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        saveData(tutor);
                                        progressBar.setVisibility(View.INVISIBLE);
                                        Toast.makeText(getApplicationContext(),"You are Succsessfully registered",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),New_profile.class);
                                        startActivity(intent);
                                    }
                                    else if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                        progressBar.setVisibility(View.INVISIBLE);
                                        Toast.makeText(getApplicationContext(),"User is already registered",Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });




                }
                else Toast.makeText(Registration_page.this,"please provide ur information",Toast.LENGTH_SHORT).show();
             }else Toast.makeText(Registration_page.this,"please provide ur information",Toast.LENGTH_SHORT).show();



         }

            }
        });






    }
    void runProgressbar()
    {
        new Thread(new Runnable() {
            public void run() {

             while (progressStatus < 100) {
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

    void saveData(Tutor tutor)
    {
       String key = databaseReference.push().getKey();
        databaseReference.child(key).setValue(tutor);
    }



}