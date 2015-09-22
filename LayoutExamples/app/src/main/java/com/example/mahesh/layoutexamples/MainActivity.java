package com.example.mahesh.layoutexamples;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelayout);
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMe();

            }
        });
    }

    private void CallMe() {
        Intent i;
        i = new Intent(this,HomeActivity.class);
        startActivity(i);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
outState.putString("PhoneNumber", editText.getText().toString());
        Log.d("INSATANCEPARAM",editText.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        editText.setText(savedInstanceState.getString("PhoneNumber"));
        Log.e("INSTANCEPARAM",savedInstanceState.getString("PhoneNumber"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        CreateMenu(menu);
        return true;
    }

    private void CreateMenu(Menu menu) {

        MenuItem menuItem=menu.add(0,1,1,"Google");
        {
            menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        MenuItem menuItem1=menu.add(0,2,2,"Yahoo");
        {

            menuItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        MenuItem menuItem2=menu.add(0,3,3,"Bing");
        {

            menuItem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

       //noinspection SimplifiableIfStatement

        return MenuChoice(item);
    }

    private boolean MenuChoice(MenuItem item) {
        switch (item.getItemId()){
            case 0:
Toast.makeText(getApplicationContext(),"You clicked Item1",Toast.LENGTH_SHORT).show();
                return true;
            case 1:
                Toast.makeText(getApplicationContext(),"You clicked Item2",Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(getApplicationContext(),"You clicked Item3",Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                Toast.makeText(getApplicationContext(),"Home button is clicked",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                return true;
        }
return false;
    }
}
