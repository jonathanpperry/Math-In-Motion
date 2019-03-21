package com.eecs481.mathinmotion;

import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


public class AIA_Settings extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aia__settings);
    }

    public static class SettingsFragment extends PreferenceFragment
    {
        //calls the fragments needed for the AIA_Settings page
        public void onCreate(Bundle instance)
        {
            super.onCreate(instance);
            addPreferencesFromResource(R.xml.aia_settings);
        }
    }
}

