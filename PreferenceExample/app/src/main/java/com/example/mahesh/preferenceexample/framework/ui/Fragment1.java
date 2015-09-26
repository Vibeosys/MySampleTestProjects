package com.example.mahesh.preferenceexample.framework.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.example.mahesh.preferenceexample.R;

/**
 * Created by mahesh on 9/26/2015.
 */
public class Fragment1 extends PreferenceFragment  {
    public static final String KEY_PREF_SYNC_CONN = "username";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make sure default values are applied.  In a real app, you would
        // want this in a shared function that is used to retrieve the
        // SharedPreferences wherever they are needed.

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.mypreferences);
    }


}