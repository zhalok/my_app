package com.example.jotno;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button login, register, search, showdata;
    ImageView back;
    ActionBar actionBar ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        login = (Button) findViewById(R.id.login_button);
        search = (Button) findViewById(R.id.look_button);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login_page.class);
                startActivity(intent);
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Available_tutors.class);
                startActivity(intent);
            }
        });


    }

}