package com.example.astroworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import android.widget.ArrayAdapter;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] cityNames = {"--select your city---","ahmedabad", "baroda", "surat"};

    Button submit;
    RadioButton RadMale, RadFemale;
    String selectedGender;

    CheckBox checkBox;

    RadioGroup radioGroup;

    TextView tvDate, tvTime;
    Button btnDate, btnTime;

    TextView tvRatingBar;
    RatingBar ratingBar;

    private int year;
    private int month, day;
    private int hour;
    private int minute;
    String user_Time;
    private EditText e_fname,e_lname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        radioGroup=findViewById(R.id.radioGroup);
        ratingBar=findViewById(R.id.ratingbar);
        tvRatingBar=findViewById(R.id.tv_ratingbar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvRatingBar.setText(String.valueOf(rating));
            }
        });

        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa=new ArrayAdapter(this, android.R.layout.simple_spinner_item,cityNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        RadMale = (RadioButton) findViewById(R.id.radioMale);
        RadFemale = (RadioButton) findViewById(R.id.radioFemale);
        submit = (Button) findViewById(R.id.button1);
        EditText firstName=(EditText)findViewById(R.id.fname);
        EditText lastName=(EditText)findViewById(R.id.lname);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String FName=firstName.getText().toString();
                final String LName=lastName.getText().toString();

                if(FName.length()==0)
                {
                    firstName.setError( "First name is required!" );
                }
                else if(!FName.matches("[a-zA-Z ]+"))
                {
                    firstName.requestFocus();
                    firstName.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                if(LName.length()==0)
                {
                    lastName.setError( "First name is required!" );
                }
                else if(!LName.matches("[a-zA-Z ]+"))
                {
                    lastName.requestFocus();
                    lastName.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
               /* if (RadMale.isChecked()) {
                    selectedGender = RadMale.getText().toString();
                } else if (RadFemale.isChecked()) {
                    selectedGender = RadFemale.getText().toString();
                }
               */// Toast.makeText(getApplicationContext(), selectedGender, Toast.LENGTH_LONG).show();

                String user_fname=firstName.getText().toString();
                String user_lname=lastName.getText().toString();

                int id=radioGroup.getCheckedRadioButtonId();

                RadioButton radioButton=findViewById(id);
                String strRadio=radioButton.getText().toString();

                checkBox=findViewById(R.id.chb);

                if(checkBox.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("key_fname", user_fname);
                    intent.putExtra("key_lname", user_lname);
                    intent.putExtra("key_gender", strRadio);
                    intent.putExtra("key_time", user_Time);

                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Select the Checkbox",Toast.LENGTH_SHORT).show();
                }
            }
        });


        tvDate = findViewById(R.id.tv_date);
        btnDate = findViewById(R.id.btn_date);


        tvTime = findViewById(R.id.tv_time);
        btnTime = findViewById(R.id.btn_time);


        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);


        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvTime.setText(hourOfDay + " : " + minute);

                         user_Time=tvTime.getText().toString();
                    }
                }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDate.setText(dayOfMonth + " / " + (month + 1) + " / " + year);


                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),cityNames[i], Toast.LENGTH_SHORT).show();
    }   

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

