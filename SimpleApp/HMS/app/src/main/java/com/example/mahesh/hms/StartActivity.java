package com.example.mahesh.hms;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mahesh on 9/15/2015.
 */
public class StartActivity extends Activity {
    String customer_id;
    String password;
    EditText cust_id;
    EditText pwd;
    Button check;
ProgressDialog progress;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.start_screen);

        cust_id=(EditText)findViewById(R.id.editText);
        pwd=(EditText)findViewById(R.id.editText2);
        check=(Button)findViewById(R.id.button);

        check.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View v) {

                      if(cust_id.getText().toString().length()==0||cust_id.getText().toString()==null){
                          cust_id.setError("Enter valid Customer id");
                      }
                      else if(pwd.getText().toString().length()==0||pwd.getText().toString()==null){
                                             pwd.setError("Enter valid password");
                                         }
                                         else{
                          String username=cust_id.getText().toString();
                          String pass=pwd.getText().toString();
                          SaveDetails(username,pass);

                          Toast.makeText(getApplicationContext(),"Validated User",Toast.LENGTH_SHORT).show();
                      }

                                   }
                                 }
        );


    }

    public void SaveDetails(String user,String pass){

        DatabaseCredentials db=new DatabaseCredentials(this);
        boolean check=db.addCustomerDetails(new DeviceDetails(user,pass,"kj"));
        if(check){
            Intent in=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(in);
        }
        else{
            Toast.makeText(getApplicationContext(),"Some error happened..",Toast.LENGTH_SHORT).show();
        }
        Log.e(StartActivity.class.getName(),"Saving Details");


    }
}
