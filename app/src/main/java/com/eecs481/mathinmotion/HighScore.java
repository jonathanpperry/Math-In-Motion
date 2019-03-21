package com.eecs481.mathinmotion;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eecs481.mathinmotion.R;

public class HighScore extends ActionBarActivity {

    SharedPreferences high_score_preference;

    private void setupToolbars()
    {
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayUseLogoEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(false);
        actionbar.setDisplayShowCustomEnabled(true);

        View custom = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView title = (TextView)custom.findViewById(R.id.actionbar_title);
        title.setText("High Scores");
        ImageView settings = (ImageView)custom.findViewById(R.id.settings_icon);
        settings.setVisibility(View.INVISIBLE);
        actionbar.setCustomView(custom);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        setupToolbars();
        high_score_preference = getSharedPreferences("high_score", Context.MODE_PRIVATE);

        TextView current = (TextView) findViewById(R.id.eight_puzzle_record);
        if(high_score_preference.contains("time"))
        {
            long record_time = high_score_preference.getLong("time",0);
            long record_seconds = record_time / 1000;
            long record_minutes = record_seconds / 60;
            record_seconds %= 60;
            current.setText(high_score_preference.getInt("moves",0) + " moves in "
                + String.format("%d:%02d", record_minutes, record_seconds));
        }
        else
        {
            current.setText("N/A");
        }
        current = (TextView) findViewById(R.id.addition_easy_record);
        if(high_score_preference.contains("aiaadditioneasyrecord"))
        {
            current.setText("Easy Addition: "+ high_score_preference.getInt("aiaadditioneasyrecord",0) );
        }
        else
        {
            current.setText("Easy Addition: N/A");
        }
        current = (TextView) findViewById(R.id.addition_medium_record);
        if(high_score_preference.contains("aiaadditionmediumrecord"))
        {
            current.setText("Medium Addition: "+ high_score_preference.getInt("aiaadditionmediumrecord",0) );
        }
        else
        {
            current.setText("Medium Addition: N/A");
        }
        current = (TextView) findViewById(R.id.addition_hard_record);
        if(high_score_preference.contains("aiaadditionhardrecord"))
        {
            current.setText("Hard Addition: "+ high_score_preference.getInt("aiaadditionhardrecord",0) );
        }
        else
        {
            current.setText("Hard Addition: N/A");
        }

        current = (TextView) findViewById(R.id.multiplication_easy_record);
        if(high_score_preference.contains("aiamultiplicationeasyrecord"))
        {
            current.setText("Easy Multiplication: "+ high_score_preference.getInt("aiamultiplicationeasyrecord",0) );
        }
        else
        {
            current.setText("Easy Multiplication: N/A");
        }
        current = (TextView) findViewById(R.id.multiplication_medium_record);
        if(high_score_preference.contains("aiamultiplicationmediumrecord"))
        {
            current.setText("Medium Multiplication: "+ high_score_preference.getInt("aiamultiplicationmediumrecord",0) );
        }
        else
        {
            current.setText("Medium Multiplication: N/A");
        }
        current = (TextView) findViewById(R.id.multiplication_hard_record);
        if(high_score_preference.contains("aiamultiplicationhardrecord"))
        {
            current.setText("Hard Multiplication: "+ high_score_preference.getInt("aiamultiplicationhardrecord",0) );
        }
        else
        {
            current.setText("Hard Multiplication: N/A");
        }


        current = (TextView) findViewById(R.id.equations_easy_record);
        if(high_score_preference.contains("aiaequationseasyrecord"))
        {
            current.setText("Easy Equations: "+ high_score_preference.getInt("aiaequationseasyrecord",0) );
        }
        else
        {
            current.setText("Easy Equations: N/A");
        }
        current = (TextView) findViewById(R.id.equations_medium_record);
        if(high_score_preference.contains("aiaequationsmediumrecord"))
        {
            current.setText("Medium Equations: "+ high_score_preference.getInt("aiaequationsmediumrecord",0) );
        }
        else
        {
            current.setText("Medium Equations: N/A");
        }
        current = (TextView) findViewById(R.id.equations_hard_record);
        if(high_score_preference.contains("aiaequationshardrecord"))
        {
            current.setText("Hard Equations: "+ high_score_preference.getInt("aiaequationshardrecord",0) );
        }
        else
        {
            current.setText("Hard Equations: N/A");
        }



        current = (TextView) findViewById(R.id.combination_easy_record);
        if(high_score_preference.contains("aiacombinationeasyrecord"))
        {
            current.setText("Easy Combination: "+ high_score_preference.getInt("aiacombinationeasyrecord",0) );
        }
        else
        {
            current.setText("Easy Combination: N/A");
        }
        current = (TextView) findViewById(R.id.combination_medium_record);
        if(high_score_preference.contains("aiacombinationmediumrecord"))
        {
            current.setText("Medium Combination: "+ high_score_preference.getInt("aiacombinationmediumrecord",0) );
        }
        else
        {
            current.setText("Medium Combination: N/A");
        }
        current = (TextView) findViewById(R.id.combination_hard_record);
        if(high_score_preference.contains("aiacombinationhardrecord"))
        {
            current.setText("Hard Combination: "+ high_score_preference.getInt("aiacombinationhardrecord",0) );
        }
        else
        {
            current.setText("Hard Combination: N/A");
        }


    }

    public void home_launch(View view)
    {
        NavUtils.navigateUpFromSameTask(this);
    }

}
