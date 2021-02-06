package com.example.jotno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class Login_page extends AppCompatActivity {
    private EditText username,password ;
    private Button login,Signup;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private Handler handler;
    private int progressStatus=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username =(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
        Signup=(Button)findViewById(R.id.signup);
        progressBar=(ProgressBar)findViewById(R.id.load);
        firebaseAuth=FirebaseAuth.getInstance();
        handler= new Handler();




        login.setOnClickListener(new View.OnClickListener() {
            @Override

           public void onClick(View view) {

                  if(username.getText().toString().matches("")||password.getText().toString().matches("")) {
                      Toast.makeText(Login_page.this,"please provide the username",Toast.LENGTH_SHORT).show();

                  }
                  else
                  {
                      progressBar.setVisibility(View.VISIBLE);

                       runProgressbar();



                      firebaseAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                              .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                  @Override
                                  public void onComplete(@NonNull Task<AuthResult> task) {
                                      if (task.isSuccessful()) {

                                              progressBar.setVisibility(View.INVISIBLE);
                                              Toast.makeText(getApplicationContext(),"Sign in Successful",Toast.LENGTH_SHORT).show();
                                              Intent intent = new Intent(getApplicationContext(),Tutor_profile.class);
                                              intent.putExtra("email",username.getText().toString());
                                              startActivity(intent);
                                              username.setText("");
                                              password.setText("");



                                      } else {

                                          progressBar.setVisibility(View.INVISIBLE);
                                          Toast.makeText(getApplicationContext(),"Sorry You are not registered",Toast.LENGTH_SHORT).show();


                                      }


                                  }
                              });



                  }



            }
        });



      Signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toast.makeText(getApplicationContext(),"welcome",Toast.LENGTH_SHORT).show();
              Intent intent = new Intent(getApplicationContext(),Registration_page.class);
              startActivity(intent);
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