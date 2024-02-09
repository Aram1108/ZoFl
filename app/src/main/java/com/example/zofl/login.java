package com.example.zofl;

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

public class login extends AppCompatActivity{

    TextView switchToSignupActivity;
    EditText email;
    EditText password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        setupUI();
        setupListeners();
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
    private void setupUI() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
    }
    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmail();
            }
        });
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
            if (emailValue.equals("test@test.com") && passwordValue.equals("password1234")) {
                Intent i = new Intent(com.example.zofl.login.this, MainActivity3.class);
                startActivity(i);

                this.finish();
            }
            else{
                Toast t = Toast.makeText(this,"Wrong email or password!",Toast.LENGTH_SHORT);
                t.show();
            }
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