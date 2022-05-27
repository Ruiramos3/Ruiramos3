package com.example.afinally;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
EditText mEmail,mPassword;
Button mRegisterBtn;
FirebaseAuth firebaseAuth;
TextView mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mEmail = findViewById(R.id.registeremail);
        mPassword = findViewById(R.id.registerPassword);
        mRegisterBtn = findViewById(R.id.button3);
        mLogin = findViewById(R.id.login2);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){  //if user is logged in go to main activity
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

        }

        mLogin.setOnClickListener(v1 -> startActivity(new Intent(getApplicationContext(), Login.class)));

        mRegisterBtn.setOnClickListener(v -> { // Register button functionality
            String email = mEmail.getText().toString();
            String password = mPassword.getText().toString();

//If statements for someone who is not properly registering
            if (email.isEmpty()) {
                mEmail.setError("Email is required");
                return;

            }
            if (password.isEmpty()) {
                mPassword.setError("Password is required");
                return;

            }
            if (password.length() < 6 ) {
                mPassword.setError("Password must be 6 or more characters ");
                return;
            }


                //firebase user creation

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(Register.this, "User Created",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));

                    }else{
                        Toast.makeText(Register.this, "Error" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });



        });

    }
}