package com.example.mahesh.simpledrag;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView destinationList_editText;
Button addmap_button;
int [] imageId={R.drawable.downloadd,R.drawable.downloade,R.drawable.downloadf,R.drawable.downloadl,R.drawable.downloadq};
String [] destListName={"Pune","Mumbai","Nanded","Amaravati","Delhi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        destinationList_editText=(AutoCompleteTextView)findViewById(R.id.destinationlist_text);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,destListName);
        destinationList_editText.setAdapter(arrayAdapter);
        addmap_button=(Button)findViewById(R.id.addmap);
        addmap_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



}