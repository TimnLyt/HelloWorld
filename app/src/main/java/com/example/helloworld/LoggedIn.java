package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoggedIn extends AppCompatActivity {
    private TextView text_input_name;
    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        getSupportActionBar().setTitle("Created");

        goBack = (Button) findViewById(R.id.back_button);

        text_input_name = findViewById(R.id.text_name);

        String username = getIntent().getStringExtra("keyname");

        text_input_name.setText(username);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}