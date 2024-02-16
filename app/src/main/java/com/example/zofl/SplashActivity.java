package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        switchActivities();
                    }
                }, 1500);
    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, login.class);
        switchActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(switchActivityIntent);
        finish();
    }
}
