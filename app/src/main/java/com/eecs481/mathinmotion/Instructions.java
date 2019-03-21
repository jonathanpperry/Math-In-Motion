package com.eecs481.mathinmotion;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Instructions extends ActionBarActivity {

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
        title.setText("Instructions");
        ImageView settings = (ImageView)custom.findViewById(R.id.settings_icon);
        settings.setVisibility(View.INVISIBLE);
        actionbar.setCustomView(custom);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        setupToolbars();
    }

    public void home_launch(View view)
    {
        NavUtils.navigateUpFromSameTask(this);
        overridePendingTransition(R.anim.slide_right, R.anim.exit_slide_right);
    }

}
