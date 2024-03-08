package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class VertebratesActivity extends AppCompatActivity {
    ImageButton profile;
    ImageButton fishes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertebrates);
        profile = findViewById(R.id.profile_button2);
        fishes = findViewById(R.id.fishes);
        fishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities2();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities1();
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
        Intent switchActivityIntent = new Intent(this, FishesActivity.class);
        switchActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(switchActivityIntent);
        finish();
    }
}