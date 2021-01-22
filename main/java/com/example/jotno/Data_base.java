package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Data_base extends AppCompatActivity {


    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        database = new Database(this);
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();




    }
}