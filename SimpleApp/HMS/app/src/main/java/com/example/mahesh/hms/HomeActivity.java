package com.example.mahesh.hms;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

/**
 * Created by mahesh on 9/16/2015.
 */
public class HomeActivity extends Activity {
SharedPreferences sharedPreferences;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_screen);


    }
    void logout(View v){
sharedPreferences=getSharedPreferences(LoginActivity.MYPREF,MODE_PRIVATE);
        SharedPreferences.Editor edit=sharedPreferences.edit();
        edit.clear();
        edit.commit();
    }
    }
