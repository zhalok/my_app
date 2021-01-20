package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration_page extends AppCompatActivity {

    Button next,load,store;
    RadioGroup gender;
    CheckBox math,phy,chem,ict;
    EditText firstname,lastname,age;
    RadioButton male,female;
    Spinner locations;
    String[] location_names;
    EditText username,password;


 //   TextView lastsavedinfo;
    boolean flag=false;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        next=(Button)findViewById(R.id.next);
        store=(Button)findViewById(R.id.store);
        username=(EditText)findViewById((R.id.username));
        password=(EditText)findViewById((R.id.password));
        gender=(RadioGroup)findViewById(R.id.gender);
        firstname=(EditText)findViewById(R.id.fname);
        lastname=(EditText)findViewById(R.id.lname);
        age=(EditText)findViewById(R.id.age);
        male=(RadioButton)findViewById(gender.getCheckedRadioButtonId());
        female=(RadioButton)findViewById(gender.getCheckedRadioButtonId());
        math=(CheckBox)findViewById(R.id.math);
        phy=(CheckBox)findViewById(R.id.phy);
        chem=(CheckBox)findViewById(R.id.chem);
        ict=(CheckBox)findViewById(R.id.ict);
        locations=(Spinner)findViewById(R.id.locations);
        location_names=getResources().getStringArray(R.array.location_names);
        CustomAdaptar2 adaptar2= new CustomAdaptar2(this,location_names);
        locations.setAdapter(adaptar2);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         if(firstname.getText().toString().matches("")||lastname.getText().toString().matches("")||age.getText().toString().matches(""))
             Toast.makeText(Registration_page.this,"please provide ur information",Toast.LENGTH_SHORT).show();
         else
         {
             if(gender.getCheckedRadioButtonId()!=-1)
             {


                if(math.isChecked()||chem.isChecked()||phy.isChecked()||ict.isChecked())
                {
                    flag = true;
                    Intent intent=new Intent(Registration_page.this,New_profile.class);
                 //   Intent intent1= new Intent(Registration_page.this,LoadData.class);
                    StringBuilder stringBuilder_name = new StringBuilder();
                    stringBuilder_name.append(firstname.getText().toString()+" ");
                    stringBuilder_name.append(lastname.getText().toString()+" ");
                    StringBuilder stringBuilder_sub=new StringBuilder();
                    StringBuilder location= new StringBuilder();
                    location.append(locations.getSelectedItem().toString());
                    if(math.isChecked()) stringBuilder_sub.append(math.getText().toString()+"\n");
                    if(phy.isChecked()) stringBuilder_sub.append(phy.getText().toString()+"\n");
                    if(chem.isChecked()) stringBuilder_sub.append(chem.getText().toString()+"\n");
                    if(ict.isChecked()) stringBuilder_sub.append(ict.getText().toString()+"\n");
                    intent.putExtra("congo","Congratulations, You are successfully registered \n");
                    intent.putExtra("name",stringBuilder_name.toString());
                    intent.putExtra("sub",stringBuilder_sub.toString());
                    intent.putExtra("loc",locations.getSelectedItem().toString());

                    startActivity(intent);



                }
                else Toast.makeText(Registration_page.this,"please provide ur information",Toast.LENGTH_SHORT).show();
             }else Toast.makeText(Registration_page.this,"please provide ur information",Toast.LENGTH_SHORT).show();



         }

            }
        });



        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Registration_page.this, Data_base.class);


                    startActivity(intent1);

            }
        });


    }
}