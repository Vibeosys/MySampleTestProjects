package com.example.mahesh.returnback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    textView=(TextView)findViewById(R.id.textView);
Intent i=new Intent(getApplicationContext(),SecondActivity.class);
        i.putExtra("name", "name");
        Bundle bundle=new Bundle();
        bundle.putString("age1","50");
        i.putExtras(bundle);

        startActivityForResult(new Intent(getApplicationContext(), SecondActivity.class), 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
if(requestCode==1){
    if(resultCode==RESULT_OK){
textView.setText(data.getData().toString());
        Log.w("Name", "" + data.getStringExtra("name1"));
        Bundle bundle1 = data.getExtras();
        Log.w("Age", "" + bundle1.getString("age2"));
        Toast.makeText(getApplicationContext(),"Retured Value  "+data.getData().toString(),Toast.LENGTH_SHORT).show();
    }
}
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
