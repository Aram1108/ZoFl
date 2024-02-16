package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {
    ImageButton animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_red);
        animal = findViewById(R.id.animal_button1);
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }
    private void switchActivities(){
        Intent switchActivityIntent = new Intent(this, MainActivity3.class);
        switchActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(switchActivityIntent);
        finish();
    }
}