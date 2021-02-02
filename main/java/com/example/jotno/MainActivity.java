package com.example.jotno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static androidx.appcompat.app.AlertDialog.*;

public class MainActivity extends AppCompatActivity {

    private Button login, register, search, showdata;
    ImageView back;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(this);
        final SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

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