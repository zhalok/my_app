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
    private Button login,load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username =(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
        final Database database = new Database(this);
       // load=(Button)findViewById((R.id.load));



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
                                   startActivity(intent);
                                   finish();
                               }
                          }

                          if(flag==false)
                          Toast.makeText(Login_page.this,"You are not registered",Toast.LENGTH_SHORT).show();
                          else {
                              Toast.makeText(Login_page.this,"Login Successful",Toast.LENGTH_SHORT).show();
                          }


                      }else {
                          Toast.makeText(Login_page.this,"You are not registered",Toast.LENGTH_SHORT).show();
                      }





                  }



            }
        });
        /*

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      SharedPreferences sharedPreferences = getSharedPreferences("tutor_detail",Context.MODE_PRIVATE);
                      if(sharedPreferences.contains("username")&&sharedPreferences.contains("password"))
                      {
                          StringBuilder dataloader= new StringBuilder();
                          String usennameloaded=sharedPreferences.getString("username","kas koros na ken be ?");
                          String passwordloaded=sharedPreferences.getString("password","hello");
                          dataloader.append((usennameloaded+'\n'));
                          dataloader.append(passwordloaded+'\n');
                          Toast.makeText(Login_page.this,dataloader.toString(),Toast.LENGTH_SHORT).show();
                          //Toast.makeText(Login_page.this,usennameloaded,Toast.LENGTH_SHORT).show();
                      }
                      else {
                          Toast.makeText(Login_page.this,"hi there",Toast.LENGTH_SHORT).show();

                      }
            }
        });
        */





    }
}