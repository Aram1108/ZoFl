package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class SignupActivity extends AppCompatActivity{

    TextView switchToSignupActivity;
    EditText username;
    EditText email;
    EditText password;
    EditText passwordRepeat;
    Button signup;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        switchToSignupActivity = findViewById(R.id.login);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passwordRepeat = findViewById(R.id.passwordrepeat);
        signup = findViewById(R.id.signup);

        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        Account[] accounts = AccountManager.get(context).getAccounts();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                String possibleEmail = account.name;
        switchToSignupActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }
    void checkDataEntered(){
        boolean isValid = true;
        if (isEmpty(username)) {
            username.setError("username is required!");
            isValid = false;
        }
        if (isEmpty(password)) {
            password.setError("password is required!");
            isValid = false;
        }else {
            if (password.getText().toString().length() < 4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }
        if (isEmpty(passwordRepeat)) {
            passwordRepeat.setError("Repeat the password!");
            isValid = false;
        }
        if (!passwordRepeat.getText().toString().equals(password.getText().toString())) {
            passwordRepeat.setError("password doesn't match!");
            isValid = false;
        }
        if (isEmail(email) == false) {
            email.setError("Email doesn't exist!");
            isValid = false;
        }
        if(isValid){
            switchActivities();
        }
    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, login.class);
        startActivity(switchActivityIntent);
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}