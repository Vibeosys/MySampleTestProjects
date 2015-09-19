package com.example.mahesh.simpledialog;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
Button bt;
    Button progress;
     ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        pd = new ProgressDialog(this);


        progress=(Button)findViewById(R.id.button1);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress();
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDiaglog();
                pd.dismiss();

            }
        });

    }

    private void showProgress() {

        pd.setProgress(0);
        pd.setTitle("Downloading...");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setCancelable(true);
        pd.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=15;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pd.incrementProgressBy((int) 100 / 15);
                }
                pd.dismiss();
            }
        }).start();
    }

    void showDiaglog(){
        String title="hello";
        FragmentManager fragmentManager=getFragmentManager();
        CustDialog custDialog=CustDialog.newInstance(title);
        custDialog.show(getFragmentManager(),null);

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
