package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity3 extends AppCompatActivity {
    ImageButton profile;
    ImageButton vertebrates;
    ImageButton game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animals);
        profile = findViewById(R.id.profile_button1);
        vertebrates = findViewById(R.id.vertebrates);
        game = findViewById(R.id.game_button1);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities3();
            }
        });
        vertebrates.setOnClickListener(new View.OnClickListener() {
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
        startActivity(switchActivityIntent);
    }
    private void switchActivities2(){
        Intent switchActivityIntent = new Intent(this, VertebratesActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchActivities3(){
        Intent switchActivityIntent = new Intent(this, GameActivity.class);
        startActivity(switchActivityIntent);
    }
}