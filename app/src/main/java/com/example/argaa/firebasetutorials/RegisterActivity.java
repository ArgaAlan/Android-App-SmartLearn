package com.example.argaa.firebasetutorials;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText tName,
            tEmail,
            tPassword;

    private Button bCreateAccount;

    private ProgressDialog mLoginProgress;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tName = findViewById(R.id.fill_name);
        tEmail = findViewById(R.id.fill_email);
        tPassword = findViewById(R.id.fill_password);
        bCreateAccount = findViewById(R.id.button_create_account);
        mAuth = FirebaseAuth.getInstance();
        mLoginProgress = new ProgressDialog(this);


        bCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = tName.getText().toString().trim();
                String email = tEmail.getText().toString().trim();
                String password = tPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(name) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)){
                    mLoginProgress.setTitle("Processing");
                    mLoginProgress.setMessage("Please wait");
                    mLoginProgress.setCanceledOnTouchOutside(false);
                    mLoginProgress.show();

                    createAccount(email,password,name);
                }

            }
        });

    }

    private void createAccount(String email, String password, String name) {

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                    Map values = new HashMap();
                    String name = tName.getText().toString();
                    values.put("Usuario",name);
                    database.setValue(values);
                    startActivity(mainIntent);
                    finish();
                } else {
                    mLoginProgress.hide();
                    Toast.makeText(RegisterActivity.this,"You got some error",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}
