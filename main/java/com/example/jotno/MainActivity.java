package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login,register,search;
    ImageView back;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            database = new Database(this);


           SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        login=(Button)findViewById(R.id.login_button);
        search=(Button)findViewById(R.id.look_button);
        register=(Button)findViewById(R.id.register_button);


       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,Login_page.class);
               startActivity(intent);
           }
       });

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,Registration_page.class);
               startActivity(intent);
           }
       });


       search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,available_tutors.class);
               startActivity(intent);
           }
       });
       

    }
}