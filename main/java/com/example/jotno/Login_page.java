package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {
    private EditText username,password ;
    private Button login,Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username =(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
        Signup=(Button)findViewById(R.id.signup);
        final Database database = new Database(this);




        login.setOnClickListener(new View.OnClickListener() {
            @Override

           public void onClick(View view) {

                  if(username.getText().toString().matches("")) {
                      Toast.makeText(Login_page.this,"please provid the username",Toast.LENGTH_SHORT).show();

                  }
                  else
                  {
                   //   Toast.makeText(Login_page.this,username.getText().toString(),Toast.LENGTH_SHORT).show();
                   //   SharedPreferences sharedPreferences=getSharedPreferences("tutor_detail", Context.MODE_PRIVATE);
                   //   SharedPreferences.Editor editor=sharedPreferences.edit();
                      Intent intent = new Intent(Login_page.this, profile.class);
                      String name = username.getText().toString();
                      intent.putExtra("name", name);
                      SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
                      Cursor cursor = database.getData(sqLiteDatabase);
                      if(cursor.getCount()>0){

                          boolean flag=false;
                          while(cursor.moveToNext())
                          {

                               String Username=cursor.getString(4);
                               String Password=cursor.getString(5);
                               if(Username.matches(username.getText().toString())&&Password.matches(password.getText().toString()))
                               {
                                   flag=true;
                                   break;
                               }
                          }

                          if(flag==false)
                          Toast.makeText(Login_page.this,"You are not registered",Toast.LENGTH_SHORT).show();
                          else {
                              startActivity(intent);
                              finish();
                              Toast.makeText(Login_page.this,"Login Successful",Toast.LENGTH_SHORT).show();
                          }


                      }else {
                          Toast.makeText(Login_page.this,"You are not registered",Toast.LENGTH_SHORT).show();
                      }





                  }



            }
        });



      Signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(),Registration_page.class);
              startActivity(intent);
          }
      });





    }
}