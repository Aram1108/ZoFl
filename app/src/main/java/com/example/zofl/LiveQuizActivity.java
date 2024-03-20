package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LiveQuizActivity extends AppCompatActivity{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score=0;
    int lives = 3;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_quiz);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswer != ""){
                if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                    score++;
                }
                else {
                    lives--;
                }
                selectedAnswer = "";
                ansA.setBackgroundColor(Color.WHITE);
                ansB.setBackgroundColor(Color.WHITE);
                ansC.setBackgroundColor(Color.WHITE);
                ansD.setBackgroundColor(Color.WHITE);
                currentQuestionIndex++;
                loadNewQuestion();
                }
            }
        });
        ansA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer  = ansA.getText().toString();
                ansA.setBackgroundColor(Color.MAGENTA);
                ansB.setBackgroundColor(Color.WHITE);
                ansC.setBackgroundColor(Color.WHITE);
                ansD.setBackgroundColor(Color.WHITE);
            }
        });
        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer  = ansB.getText().toString();
                ansB.setBackgroundColor(Color.MAGENTA);
                ansA.setBackgroundColor(Color.WHITE);
                ansC.setBackgroundColor(Color.WHITE);
                ansD.setBackgroundColor(Color.WHITE);
            }
        });
        ansC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer  = ansC.getText().toString();
                ansC.setBackgroundColor(Color.MAGENTA);
                ansA.setBackgroundColor(Color.WHITE);
                ansB.setBackgroundColor(Color.WHITE);
                ansD.setBackgroundColor(Color.WHITE);
            }
        });
        ansD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer  = ansD.getText().toString();
                ansD.setBackgroundColor(Color.MAGENTA);
                ansA.setBackgroundColor(Color.WHITE);
                ansB.setBackgroundColor(Color.WHITE);
                ansC.setBackgroundColor(Color.WHITE);
            }
        });
    }
    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            lives = 3;
            return;
        }
        if (lives == 0 && currentQuestionIndex!=totalQuestion){
            finishQuiz();
            Toast.makeText(this, "You have lost all your lives", Toast.LENGTH_SHORT).show();
            lives = 3;
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}