package com.example.mahesh.hms;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mahesh on 9/16/2015.
 */
public class LoginActivity extends Activity{
    TextView customer_name;
    EditText loginid;
    SharedPreferences sharedPreferences;
    static final String MYPREF="mypref";
    EditText pass;
 Button login;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.login_screen);
        customer_name=(TextView)findViewById(R.id.cname);
loginid=(EditText)findViewById(R.id.editText);
        sharedPreferences=getSharedPreferences(MYPREF,MODE_PRIVATE);
        pass=(EditText)findViewById(R.id.editText2);
login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginid.getText().toString().length()==0||loginid.getText().toString()==null){
                    loginid.setError("Please enter some userId");
                }else if(pass.getText().toString().length()==0||pass.getText().toString()==null){
                    pass.setError("Please enter some password");
                }
                else{
                    String username=loginid.getText().toString();
                    String password =pass.getText().toString();
DatabaseCredentials databaseCredentials=new DatabaseCredentials(getApplicationContext());
                    boolean _check= databaseCredentials.checkLoginCredentials(new LoginCredentials(username,password));
                    Log.e("CheckStatus",""+_check);
if(_check==true){
    SharedPreferences.Editor editor=sharedPreferences.edit();
editor.putBoolean("isLoggedin",true);
    editor.putString("userId",loginid.getText().toString());
    editor.commit();

    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
    startActivity(intent);
}else{
    Toast.makeText(getApplicationContext(),"Please check UserId and Password",Toast.LENGTH_SHORT).show();
}
                }
            }
        });

    }
}
