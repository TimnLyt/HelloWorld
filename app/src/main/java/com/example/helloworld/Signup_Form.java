package com.example.helloworld;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import com.example.helloworld.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.util.Calendar;

public class Signup_Form extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button button;
    private EditText text_input_name, text_input_occupation, text_input_description, text_input_email;
    private Button birthday;
    private TextView birthdayText;
    private EditText text_input_username;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        text_input_name = findViewById(R.id.text_input_name);
        text_input_occupation = findViewById(R.id.text_input_occupation);
        text_input_description = findViewById(R.id.text_input_description);
        text_input_username = findViewById(R.id.text_input_username);
        text_input_email = findViewById(R.id.text_input_email);


        birthdayText = findViewById(R.id.birthdayText);

        button = findViewById(R.id.button);
        getSupportActionBar().setTitle("Dating Profile Signup Form");

        button.setOnClickListener(v -> {
            String name = text_input_name.getText().toString();
            String occupation = text_input_occupation.getText().toString();
            String description = text_input_description.getText().toString();
            String username = text_input_username.getText().toString();
            String email = text_input_email.getText().toString();
            String age = birthdayText.getText().toString();

            // Must have some text in order to sign up
            // Must not go over a specific char amount
            if (text_input_name.length()==0) {
                text_input_name.setError("Enter Name");
                } else if (text_input_name.length()>19) {
                    text_input_name.setError("Must be below 19 Char");
            }
            if (text_input_occupation.length()==0) {
                text_input_occupation.setError("Enter Occupation");
                } else if (text_input_occupation.length()>15) {
                    text_input_occupation.setError("Must be below 15 Char");
            }
            if (text_input_username.length()==0) {
                text_input_username.setError("Enter Username");
                } else if (text_input_username.length()>15) {
                    text_input_username.setError("Must be below 15 Char");
            }
            if (text_input_email.length()==0) {
                text_input_email.setError("Enter Email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    text_input_email.setError("Must be a valid email");
            }
            if (text_input_description.length()==0) {
                text_input_description.setError("Enter Description");
                } else if (text_input_description.length()>75) {
                    text_input_description.setError("Must be below 75 Char");
            } else {
                Intent intent = new Intent(Signup_Form.this,activity_main.class);
                intent.putExtra("keyname",name);
                intent.putExtra("keyoccupation",occupation);
                intent.putExtra("keydescription",description);
                intent.putExtra("keyusername",username);
                intent.putExtra("keyage",age);
                startActivity(intent);
            }
        });

        Button button = (Button) findViewById(R.id.birthday);
        button.setOnClickListener(v -> {
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "date picker");
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.birthdayText);
        textView.setText(currentDateString);
    }

    public void goToSimpleFirebaseExample(View view) {
        Intent intent = new Intent(Signup_Form.this, SimpleFirebaseExample.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}