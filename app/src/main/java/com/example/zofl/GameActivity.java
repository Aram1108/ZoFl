package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GameActivity extends AppCompatActivity {
    ImageButton quizLives;
    ImageButton quizTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        quizLives = findViewById(R.id.game_1);
        quizTime = findViewById(R.id.game_2);
        quizTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities2();
            }
        });
        quizLives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities1();
            }
        });
    }
    private void switchActivities1(){
        Intent switchActivityIntent = new Intent(this, LiveQuizActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchActivities2(){
        Intent switchActivityIntent = new Intent(this, TimeQuizActivity.class);
        startActivity(switchActivityIntent);
    }
}