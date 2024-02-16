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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;


public class SignupActivity extends AppCompatActivity{

    private TextView switchToSignupActivity;
    private FirebaseAuth auth;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText passwordRepeat;
    private Button signup;




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
        auth = FirebaseAuth.getInstance();
                switchToSignupActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switchActivities();
                    }
                });
                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String user = email.getText().toString().trim();
                        String pass = password.getText().toString().trim();
                        checkDataEntered();
                        if (!pass.isEmpty()){
                            auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(SignupActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                        switchActivities();
                                    }
                                    else {
                                        Toast.makeText(SignupActivity.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
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
        switchActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(switchActivityIntent);
        finish();
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