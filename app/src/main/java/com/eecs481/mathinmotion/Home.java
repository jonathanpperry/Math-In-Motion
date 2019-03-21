package com.eecs481.mathinmotion;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Home extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void eight_puzzle_launch(View view)
    {
        Intent intent = new Intent(this, EightPuzzle.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_left, R.anim.home_slide_left);
    }

    public void algebra_launch(View view)
    {
        Intent intent = new Intent(this, AlgebraInAction.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_left, R.anim.home_slide_left);
    }

    public void instructions_launch(View view)
    {
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_left, R.anim.home_slide_left);
    }
    public void highscores_launch(View view)
    {
        Intent intent = new Intent(this, HighScore.class);
        startActivity(intent);
    }
}
