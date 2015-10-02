package com.example.mahesh.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by mahesh on 10/2/2015.
 */
public class LoginActivity extends AppCompatActivity{
Button login_button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        login_button=(Button)findViewById(R.id.btnLogin);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ConformOTPActivity.class);
                startActivity(i);
            }
        });
    }
}
