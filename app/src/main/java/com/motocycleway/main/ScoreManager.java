package com.motocycleway.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;


public class ScoreManager {

    private static ScoreManager scoreManager = new ScoreManager();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private List<Integer> highScores;
    private ScoreManager(){
        highScores = new ArrayList<>();
        highScores.add(0);
        highScores.add(0);
        highScores.add(0);
        highScores.add(0);
    }

    public static ScoreManager getScoreManager() {
        if(scoreManager==null) return new ScoreManager();
        else return scoreManager;
    }

    public void initPrefs(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void saveScore(int score){
        highScores.add(score);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            highScores.sort((b,a)-> a.compareTo(b) );
        }
        highScores.remove(highScores.remove(highScores.size()-1));

        editor.putInt("ThirdHighScore",highScores.get(2));
        editor.commit();
        editor.putInt("SecondHighScore",highScores.get(1));
        editor.commit();
        editor.putInt("FirstHighScore",highScores.get(0));
        editor.commit();
    }

    public int getScore(int choose){
        switch (choose){
            case 1:
                return sharedPreferences.getInt("FirstHighScore",0);
            case 2:
                return sharedPreferences.getInt("SecondHighScore",0);
            case 3:
                return sharedPreferences.getInt("ThirdHighScore",0);
            default:
                return 0;

        }


    }


}
