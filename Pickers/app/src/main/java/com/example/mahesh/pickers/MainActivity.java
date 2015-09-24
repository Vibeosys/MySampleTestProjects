package com.example.mahesh.pickers;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
Button time_button;
    Button date_button;
    TextView time_text;
    TextView date_text;
    TextView country_text;
    Button country_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time_button=(Button)findViewById(R.id.button);
        country_text=(TextView)findViewById(R.id.countryname);
        country_button=(Button)findViewById(R.id.button3);
        date_button=(Button )findViewById(R.id.button2);
        time_text=(TextView)findViewById(R.id.time);
        date_text=(TextView)findViewById(R.id.date);

        time_button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              PickTime timePicker = new PickTime();
              timePicker.show(getFragmentManager(), "timePicker");
          }
        });

        country_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ShowListView.class);
                startActivity(intent);
            }
        });

        date_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        PickDate pickDate=new PickDate();
            pickDate.show(getFragmentManager(),"PickDate");
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
