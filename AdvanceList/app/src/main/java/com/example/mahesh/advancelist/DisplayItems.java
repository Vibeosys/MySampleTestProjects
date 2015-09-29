package com.example.mahesh.advancelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mahesh on 9/29/2015.
 */
public class DisplayItems extends Activity {
TextView name;
ImageView imageView;
    int [] imageIds={R.drawable.download,R.drawable.downloadd,R.drawable.downloade,R.drawable.downloadf,R.drawable.downloadl,R.drawable.downloadq};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(TextView)findViewById(R.id.textView);
        imageView=(ImageView)findViewById(R.id.imageView);
        Intent intent=getIntent();
        String name1=intent.getStringExtra("Name");
        int id1=intent.getIntExtra("Id",0);
        name.setText("Welcome  "+name1);
        imageView.setImageResource(imageIds[id1]);
    }
}
