package com.example.argaa.firebasetutorials;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class StartActivity extends AppCompatActivity {

    private Button bRegister,
                   bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        bRegister = findViewById(R.id.sign_button);
        bLogin = findViewById(R.id.login_button);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent reg_intent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(reg_intent);

            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sign_intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(sign_intent);
            }
        });
    }
}