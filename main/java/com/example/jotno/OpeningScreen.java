package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class OpeningScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_opening_screen);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
           try {
               Thread.sleep(3000);
               Intent intent = new Intent(OpeningScreen.this,MainActivity.class);
               startActivity(intent);
               finish();


           }catch (Exception e)
           {

           }


            }
        });
        thread.start();


    }
}