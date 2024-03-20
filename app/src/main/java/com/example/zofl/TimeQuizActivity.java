package com.example.zofl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimeQuizActivity extends AppCompatActivity{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    CountDownTimer countDown;
    long time = 10000;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    static int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_quiz);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();
        timeRestart();



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswer != ""){
                    if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                        score++;
                    }
                    currentQuestionIndex++;
                    timeRestart();
                    selectedAnswer = "";
                    ansA.setBackgroundColor(Color.WHITE);
                    ansB.setBackgroundColor(Color.WHITE);
                    ansC.setBackgroundColor(Color.WHITE);
                    ansD.setBackgroundColor(Color.WHITE);
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
    void timeRestart(){
        int currentIndex = currentQuestionIndex;
        countDown = new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                if(currentQuestionIndex == currentIndex){
                    finishQuiz();
                    Toast.makeText(TimeQuizActivity.this, "Time has expired", Toast.LENGTH_SHORT).show();
                }
                else{
                }
            }
        };
        countDown.start();
    }
    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
        timeRestart();
    }

}