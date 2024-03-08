package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FishesActivity extends AppCompatActivity {
    ImageButton gwsbtn;
    ImageButton profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishes);
        gwsbtn = findViewById(R.id.GWSbtn);
        profile = findViewById(R.id.profile_button1);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities1();
            }
        });
        gwsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities2();
            }
        });
    }
    private void switchActivities1(){
        Intent switchActivityIntent = new Intent(this, ProfileActivity.class);
        switchActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(switchActivityIntent);
        finish();
    }
    private void switchActivities2(){
        Intent switchActivityIntent = new Intent(this, GWSActivity.class);
        switchActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(switchActivityIntent);
        finish();
    }
}