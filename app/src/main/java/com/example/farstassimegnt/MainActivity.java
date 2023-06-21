package com.example.farstassimegnt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuestionsAdapter adapter;
    private ArrayList<Questions> questionsList;
    private int score = 0;

    private static final int SPLASH_SCREEN_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Apply animations to the splash screen elements
        ImageView logo = findViewById(R.id.logo);
        TextView title = findViewById(R.id.title);



        // Animation for title (example: fade in with delay)
        Animation titleAnimation = new AlphaAnimation(0, 1);
        titleAnimation.setDuration(1000);
        titleAnimation.setStartOffset(1000);
        title.startAnimation(titleAnimation);

        // Wait for a certain duration before proceeding to the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_DURATION);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        questionsList = new ArrayList<>();
        fillQuestions();

        adapter = new QuestionsAdapter(questionsList);
        recyclerView.setAdapter(adapter);
    }


    public void Check(View view) {
        score = 0;
        for (int i = 0; i < questionsList.size(); i++) {
            Questions question = questionsList.get(i);
            String answerString = question.getAnswer();
            if (!answerString.isEmpty()) {
                int answer = Integer.parseInt(answerString);
                if (answer == question.getElectronNumber()) {
                    score += 5;
                }
            }
        }
        Toast.makeText(this, "Score: " + score, Toast.LENGTH_SHORT).show();
    }

    public void fillQuestions() {
        SharedPreferences sharedPreferences = getSharedPreferences("QuestionsData", MODE_PRIVATE);

        // Check if the questions are already stored in SharedPreferences
        if (sharedPreferences.contains("question_1")) {
            // Questions data is already stored, retrieve it from SharedPreferences
            for (int i = 1; i <= 20; i++) {
                String element = sharedPreferences.getString("question_" + i + "_element", "");
                int electronNumber = sharedPreferences.getInt("question_" + i + "_electron_number", 0);

                if (!element.isEmpty() && electronNumber != 0) {
                    Questions question = new Questions(element, electronNumber);
                    questionsList.add(question);
                }
            }
        } else {
            // Questions data is not stored, add default questions and store them in SharedPreferences
            questionsList.add(new Questions("Fe", 26));
            questionsList.add(new Questions("Na", 11));
            questionsList.add(new Questions("O", 8));
            questionsList.add(new Questions("Cu", 29));
            questionsList.add(new Questions("He", 2));
            questionsList.add(new Questions("Cl", 17));
            questionsList.add(new Questions("Au", 79));
            questionsList.add(new Questions("Ne", 10));
            questionsList.add(new Questions("K", 19));
            questionsList.add(new Questions("S", 16));
            questionsList.add(new Questions("Zn", 30));
            questionsList.add(new Questions("Br", 35));
            questionsList.add(new Questions("Al", 13));
            questionsList.add(new Questions("N", 7));
            questionsList.add(new Questions("Hg", 80));
            questionsList.add(new Questions("C", 6));
            questionsList.add(new Questions("Li", 3));
            questionsList.add(new Questions("Ag", 47));
            questionsList.add(new Questions("Mg", 12));
            questionsList.add(new Questions("Si", 14));
            questionsList.add(new Questions("P", 15));

            // Store the questions data in SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            for (int i = 0; i < questionsList.size(); i++) {
                Questions question = questionsList.get(i);
                editor.putString("question_" + (i + 1) + "_element", question.getElement());
                editor.putInt("question_" + (i + 1) + "_electron_number", question.getElectronNumber());
            }
            editor.apply();
        }
    }
}
