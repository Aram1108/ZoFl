package com.example.zofl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity{

    private TextView switchToSignupActivity;
    private FirebaseAuth auth;
    private EditText email;
    private EditText password;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        setContentView(R.layout.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String pass = password.getText().toString();
                if(!Email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    if(!pass.isEmpty()){
                        auth.signInWithEmailAndPassword(Email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                checkEmail();
                            }
                        });
                        auth.signInWithEmailAndPassword(Email, pass).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(login.this, "Wrong email or password!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        });
        switchToSignupActivity= findViewById(R.id.signup);
        switchToSignupActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, SignupActivity.class);
        startActivity(switchActivityIntent);
    }
    void checkEmail(){
        boolean isValid = true;
        if (isEmpty(email)) {
            email.setError("You must enter email to login!");
            isValid = false;
        }
        else{
            if (!isEmail(email)) {
                email.setError("Enter valid email!");
                isValid = false;
            }
        }
        if (isEmpty(password)) {
            password.setError("You must enter password to login!");
            isValid = false;
        }
        if (isValid) {
            String emailValue = email.getText().toString();
            String passwordValue = password.getText().toString();
            Intent i = new Intent(com.example.zofl.login.this, MainActivity3.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}