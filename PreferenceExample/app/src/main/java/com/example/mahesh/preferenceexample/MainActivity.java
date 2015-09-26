package com.example.mahesh.preferenceexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.mahesh.preferenceexample.framework.ui.Fragment1;

/**
 * Created by mahesh on 9/26/2015.
 */
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment1 fragment = new Fragment1();
        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();

        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        Toast.makeText(this,sharedPrefs.getString("username","name"),Toast.LENGTH_SHORT).show();
    }




}
