package com.example.mahesh.returnback;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mahesh on 9/19/2015.
 */
public class SecondActivity extends Activity {
    EditText name;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        name=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString()!=null||name.getText().toString().length()>0){
                    String fname =name.getText().toString();

                    Intent intent=new Intent();
                    intent.setData(Uri.parse(fname));

                    intent.putExtra("name1", "Mahesh");
                    Bundle bundle=new Bundle();
                    bundle.putString("age2","12");
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invlaid Data",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
