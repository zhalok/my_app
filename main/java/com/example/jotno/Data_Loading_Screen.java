package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class Data_Loading_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__loading__screen);

        Database database = new Database(this);
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        Cursor cursor = database.getData(sqLiteDatabase);
        if(cursor.getCount()>0){
            Vector<String>names = new Vector<String>();
            Vector<String>locations = new Vector<String>();
            while(cursor.moveToNext())
            {
                 String name=cursor.getString(1);
                 String location=cursor.getString(2);
                 names.add(name);
                 locations.add(location);
            }

            String[] strnames=new String[100000];
            String[] strlocations= new String[100000];
            names.copyInto(strnames);
            locations.copyInto(strlocations);
            Intent intent = new Intent(Data_Loading_Screen.this,Available_tutors.class);
            intent.putExtra("names",strnames);
            intent.putExtra("locations",strlocations);
            startActivity(intent);
        }
        else {
            Toast.makeText(Data_Loading_Screen.this,"No Tutors",Toast.LENGTH_SHORT).show();
            finish();
        }



    }
}