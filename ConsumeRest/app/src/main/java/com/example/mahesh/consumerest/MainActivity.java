package com.example.mahesh.consumerest;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    NetworkUtils networkUtils;

    ProgressDialog pDialog;//http://api.androidhive.info/contacts/  http://192.168.1.142:80/SocialProject/api/users "http://androidexample.com/media/webservice/JsonReturn.php"
    static  final String Call_URL="http://192.168.1.142:80/SocialProject/api/insert";
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
                    } else {
                        if(new NetworkUtils().isActiveNetworkAvailable(getApplicationContext())) {
                            new LoginService().execute(Call_URL);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Internet not found...",Toast.LENGTH_SHORT).show();
                        }
                    }

                    }
                    }

        });
    }



    private class LoginService extends AsyncTask<String,Void,String>{



    @Override
    protected void onPostExecute(String s) {

        pDialog.dismiss();
        if(s!=null) Log.d("RESPONSE RECEIVED...", s);
       /* try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                Log.d("USER ID  ",jsonObject1.getString("user_id"));
                Log.d("USERNAME  ",jsonObject1.getString("username"));
                Log.d("NAME  ",jsonObject1.getString("name"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }*/


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
            url = new URL(params[0]);
            Log.d("URL Calling  ", Call_URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            Log.d("STATUS", "Request Sended...");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.connect();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("username", "mahesh");
            jsonObject.put("name", "roy");
            jsonObject.put("password", "6600");
            jsonObject.put("name","Niteen");
            outputStreamWriter=new OutputStreamWriter(urlConnection.getOutputStream());
            outputStreamWriter.write(jsonObject.toString());
            outputStreamWriter.flush();
            outputStreamWriter.close();
            Log.d("STATUS","DATA SENDED.... "+jsonObject.toString());
          int Http_Result=urlConnection.getResponseCode();
            Log.d("RESPONSE CODE", String.valueOf(Http_Result));
            switch (Http_Result){
                case  HttpURLConnection.HTTP_OK:
                    bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
                    String line=null;
                    while ((line=bufferedReader.readLine())!=null){
                        stringBuilder.append(line);
                    }
                    bufferedReader.close();
                    break;
                case HttpURLConnection.HTTP_CLIENT_TIMEOUT:
                     Log.d("STATUS ","Time Out Occours During Connecting to server..");
                    break;
                 case HttpURLConnection.HTTP_BAD_GATEWAY:
                     Log.d("STATUS ","BAD GATEWAY REQUEST ...");
                     break;
                case HttpURLConnection.HTTP_INTERNAL_ERROR:
                    Log.d("STATUS ","HTTP INTERNAL ERROR");
                    break;
                case HttpURLConnection.HTTP_UNAUTHORIZED:
                    Log.d("STATUS ","HTTP UNAUTHORIZED.");
                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:
                    Log.d("STATUS","HTTP NOT FOUND..");
                    break;
                case HttpURLConnection.HTTP_BAD_METHOD:
                    Log.d("STATUS","HTTP_BAD_METHOD");
                    break;

            }


             content=stringBuilder.toString();

        } catch (MalformedURLException e1){
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (JSONException e) {
            e.printStackTrace();
        }*/ catch (JSONException e) {
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
