package com.example.mahesh.consumerest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText mobile_edit;
EditText pass_edit;
Button button_login;
String content;
    ProgressDialog pDialog;
    static  final String Call_URL="http://hmkcode.appspot.com/jsonservlet";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //progressBar=new ProgressDialog(getApplicationContext());
        mobile_edit=(EditText)findViewById(R.id.editText_mob);
        pass_edit=(EditText)findViewById(R.id.editText_password);
        button_login=(Button)findViewById(R.id.login_button);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mobile_edit.getText().toString() == null || mobile_edit.getText().toString().length() <= 0) {
                    mobile_edit.setError("Please Enter Valid Mobile Number.");
                } else {
                    if (pass_edit.getText().toString() == null || pass_edit.getText().toString().length() <= 3) {
                        pass_edit.setError("Please enter valid more then 3 charecters.");
                    } else new LoginService().execute(Call_URL);
                }
            }
        });
    }



    private class LoginService extends AsyncTask<String,Void,String>{


    @Override
    protected void onPostExecute(String s) {
       pDialog.dismiss();
        Log.d("OUTPUT",s);
        JSONArray jsonObjectRes;
        JSONObject json;
        int length;
        try{
            jsonObjectRes=new JSONArray(s);

            length=jsonObjectRes.length();
            for(int i=0;i<length;i++) {
             json=jsonObjectRes.getJSONObject(i);
                Log.d("RESULT", json.getString("name"));
                Log.d("MESSAGE",json.getString("country"));
                Log.d("T",json.getString("twitter"));
            }
       }catch (JSONException e ){
         e.printStackTrace();
        }catch (ClassCastException ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
super.onPreExecute();
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();


    }

    @Override
    protected String doInBackground(String... params) {
        URL url;
        HttpURLConnection urlConnection;
        OutputStreamWriter outputStreamWriter;
        StringBuilder stringBuilder=new StringBuilder();

        BufferedReader bufferedReader;
        try {
            url= new URL(Call_URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.connect();
            JSONObject jsonObject=new JSONObject();
            //jsonObject.put("ID","1");
            //jsonObject.put("Name","mahesh");
            outputStreamWriter=new OutputStreamWriter(urlConnection.getOutputStream());
            outputStreamWriter.write(jsonObject.toString());
            outputStreamWriter.flush();
            outputStreamWriter.close();
            int Http_Result=urlConnection.getResponseCode();
            if(Http_Result==HttpURLConnection.HTTP_OK){
                bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
                String line=null;
                while ((line=bufferedReader.readLine())!=null){
                    stringBuilder.append(line);
                }
                bufferedReader.close();
            }
            content=stringBuilder.toString();

        } catch (MalformedURLException e1){
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return content;
    }
}

    private void ExecuteBack() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
