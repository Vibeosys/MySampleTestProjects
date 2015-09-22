package com.example.mahesh.layoutexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by mahesh on 9/22/2015.
 */
public class HomeActivity extends Activity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallHim();
            }
        });
    }

    private void CallHim() {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

}
