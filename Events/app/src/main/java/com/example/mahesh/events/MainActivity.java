package com.example.mahesh.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
ImageButton imageButton;
    Button button,bt;
CheckBox checkBox;
ToggleButton toggleButton;
    RadioGroup radioGroup;
    RadioButton rd;
    RadioButton rd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.editText);
        String [] countries=getResources().getStringArray(R.array.country_name);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        autoCompleteTextView.setAdapter(adapter);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               rd =(RadioButton)findViewById(R.id.radio1);
                rd1=(RadioButton)findViewById(R.id.rd2);
                if(rd.isChecked())Toast.makeText(getApplicationContext(),"Male is Clicked",Toast.LENGTH_SHORT).show();
                if(rd1.isChecked())Toast.makeText(getApplicationContext(),"Female is Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked()) Toast.makeText(getApplicationContext(),"Toggle button is clicked...",Toast.LENGTH_SHORT).show();

            }
        });
        imageButton=(ImageButton)findViewById(R.id.imageButton);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
Toast.makeText(getApplicationContext(),"Checkbox is clicked",Toast.LENGTH_SHORT).show();
                }

            }
        });
        button=(Button)findViewById(R.id.button1);
        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You clicked on boardless button",Toast.LENGTH_SHORT).show();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You clicked on image",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Toast.makeText(getApplicationContext(), "Center was pressed", Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                Toast.makeText(getApplicationContext(),"Down was Pressed",Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Toast.makeText(getApplicationContext(),"Left was Pressed",Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Toast.makeText(getApplicationContext(),"Right was pressed",Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                Toast.makeText(getApplicationContext(),"Up was Pressed",Toast.LENGTH_SHORT).show();
                return true;
        }

        return false;
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
