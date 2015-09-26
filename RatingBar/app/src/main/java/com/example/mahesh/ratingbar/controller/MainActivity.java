package com.example.mahesh.ratingbar.controller;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.mahesh.ratingbar.R;
import com.example.mahesh.ratingbar.framework.ui.ShowDialog;

public class MainActivity extends AppCompatActivity {
Button button,showdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      button=(Button)findViewById(R.id.button);
      showdialog=(Button)findViewById(R.id.button2);
        showdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewBar();

            }
        });
    }

    private void ShowDialog() {
        FragmentManager fragmentManager=getFragmentManager();
        ShowDialog showdialog=new ShowDialog();
        showdialog.show(fragmentManager,"showDialog");

    }

    private PopupWindow popupWindowCompat;

     void ViewBar() {
        LayoutInflater layoutInflater=(LayoutInflater)MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.rate_bar,(ViewGroup)findViewById(R.id.li));
        popupWindowCompat=new PopupWindow(view,500,500,true);
        popupWindowCompat.showAtLocation(view, Gravity.CENTER,0,0);
        RatingBar ratingBar= (RatingBar) (RatingBar) view.findViewById(R.id.ratingBar);
        Button button1=(Button)view.findViewById(R.id.submit);
         ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),"Your Rating is   "+rating,Toast.LENGTH_SHORT).show();
            }
        });
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               popupWindowCompat.dismiss();
           }
       });



    }
public void Rate(float rate){
    Toast.makeText(getApplicationContext(),"Your Rating is   "+rate,Toast.LENGTH_SHORT).show();
}
public void dismissDialog(){

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
