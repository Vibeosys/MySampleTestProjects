package com.example.mahesh.hms;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by mahesh on 9/15/2015.
 */
public class StartActivity extends Activity {
    String customer_id;
    String password;
    EditText cust_id;
    EditText pwd;
    Button check;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        super.setContentView(R.layout.start_screen);

        cust_id=(EditText)findViewById(R.id.editText);
        pwd=(EditText)findViewById(R.id.editText2);
        check=(Button)findViewById(R.id.button);

        check.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View v) {

                      customer_id=cust_id.getText().toString();
                      password=pwd.getText().toString();
if(){


}
                                         else{
    
                                         }
                                     }
                                 }
        );


    }
}
