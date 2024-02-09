package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Intent switchActivityIntent = new Intent(this, SignupActivity.class);
            startActivity(switchActivityIntent);
        }

    }
}
