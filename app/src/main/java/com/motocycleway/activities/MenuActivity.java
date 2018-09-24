package com.motocycleway.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.motocycleway.R;

public class MenuActivity extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.setContentView(R.layout.menu_layout);
    }




    public void setGameActivity(View view){
        startActivity(new Intent(this,MainGameActivity.class));
    }

    public void setSettingsActivity(View view){
startActivity(new Intent(this,SettingsActivity.class));
    }

    public void exit(View view){
        finishAffinity();

        System.exit(0);
    }
}
