package com.example.afinally;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText mEmail,mPassword;
    TextView mLoginBtn;
    TextView mSignup;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);


        mEmail = findViewById(R.id.editTextTextEmailAddress);
        mPassword = findViewById(R.id.editTextTextPassword);
        mLoginBtn = findViewById(R.id.button2);
        mSignup = findViewById(R.id.signup);
        progressBar = findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();


        mSignup.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(),Register.class))
        );


        mLoginBtn.setOnClickListener(v -> {
            String email = mEmail.getText().toString();
            String password = mPassword.getText().toString();

//If statements for someone who is not properly login in
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

            progressBar.setVisibility(View.VISIBLE);

            //authentication
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Logged in Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }else{
                    Toast.makeText(Login.this, "Login Failed" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }

            });
        });

    }
}