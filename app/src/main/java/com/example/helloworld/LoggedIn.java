package com.example.helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoggedIn extends AppCompatActivity {
    private TextView text_input_name, text_input_occupation, text_input_description;
    private Button goBack;
    private TextView text_age;
    private TextView birthdayText;
    private TextView text_input_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        getSupportActionBar().setTitle("Dating Profile");

        goBack = (Button) findViewById(R.id.back_button);

        text_input_name = findViewById(R.id.text_name);
        text_input_occupation = findViewById(R.id.text_occupation);
        text_input_description = findViewById(R.id.text_description);
        text_input_username = findViewById(R.id.text_username);
        birthdayText = findViewById(R.id.text_age);


        String name = getIntent().getStringExtra("keyname");
        String occupation = getIntent().getStringExtra("keyoccupation");
        String description = getIntent().getStringExtra("keydescription");
        String username = getIntent().getStringExtra("keyusername");
        String age = getIntent().getStringExtra("keyage");

        text_input_name.setText(name);
        text_input_occupation.setText(occupation);
        text_input_description.setText(description);
        text_input_username.setText(username);
        birthdayText.setText(age);

        goBack.setOnClickListener(v -> finish());
    }
}