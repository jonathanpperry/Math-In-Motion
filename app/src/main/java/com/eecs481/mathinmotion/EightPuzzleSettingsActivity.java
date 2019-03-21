package com.eecs481.mathinmotion;

import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class EightPuzzleSettingsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_puzzle_settings);
    }

    public static class SettingsFragment extends PreferenceFragment
    {
        public void onCreate(Bundle instance)
        {
            super.onCreate(instance);
            addPreferencesFromResource(R.xml.eight_puzzle_settings);
        }
    }
}