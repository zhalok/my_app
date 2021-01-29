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

    private Button login,register,search,showdata;
    ImageView back;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            database = new Database(this);
            final SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        login=(Button)findViewById(R.id.login_button);
        search=(Button)findViewById(R.id.look_button);
        register=(Button)findViewById(R.id.register_button);
        showdata=(Button)findViewById(R.id.Show_data);


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
               Intent intent = new Intent(MainActivity.this,Data_Loading_Screen.class);
               startActivity(intent);
           }
       });

       showdata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             SQLiteDatabase sqLiteDatabase1 = database.getWritableDatabase();
             Cursor cursor = database.getData(sqLiteDatabase);

             if(cursor.getCount()>0)
             {
                 StringBuilder message=new StringBuilder();
                 while(cursor.moveToNext())
                 {

                        message.append("ID: "+cursor.getString(0)+"\n");
                        message.append("Name: "+cursor.getString(1)+"\n");
                        message.append("Location: "+cursor.getString(2)+"\n");
                        message.append("Subs: \n"+cursor.getString(3)+"\n\n");
                 }
                 MakeAlertDialouge("Information",message.toString());
             }
             else
                 Toast.makeText(MainActivity.this, "No tutors have registered", Toast.LENGTH_SHORT).show();

           }
       });

    }
    public void MakeAlertDialouge(String Title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}