package com.motocycleway.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.motocycleway.R;
import com.motocycleway.main.ScoreManager;

public class HighScoresActivity extends AppCompatActivity {
    TextView firstScore,secondScore,thirdScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        firstScore = findViewById(R.id.firstHighScore);
        firstScore.setText(String.valueOf(readScore(1)));

        secondScore = findViewById(R.id.secondHighScore);
        secondScore.setText(String.valueOf(readScore(2)));

        thirdScore = findViewById(R.id.thirdHighScore);
        thirdScore.setText(String.valueOf(readScore(3)));

    }


    public int readScore(int choose){
        return ScoreManager.getScoreManager().getScore(choose);
    }
}
