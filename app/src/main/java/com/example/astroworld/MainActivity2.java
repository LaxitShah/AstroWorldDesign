package com.example.astroworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView first_name,last_name,genderSelected,time_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        first_name=findViewById(R.id.text_fname);
        last_name=findViewById(R.id.text_lname);
        genderSelected=findViewById(R.id.text_gender);
        time_show=findViewById(R.id.text_time);



        String u_fname=getIntent().getStringExtra("key_fname");
        String u_lname=getIntent().getStringExtra("key_lname");
        String u_gender=getIntent().getStringExtra("key_gender");
        String u_time=getIntent().getStringExtra("key_time");

        first_name.setText("first name: "+u_fname);
        last_name.setText("\n last name: "+u_lname);
        genderSelected.setText("\n Gender:"+u_gender);
        time_show.setText("\n Time: "+u_time);


    }
}