package com.example.mahesh.menuswviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        CreateMenu(menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return MenuChoice(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        CreateMenu(menu);
        return true;
    }

    void CreateMenu(Menu menu){
        menu.setQwertyMode(true);
MenuItem menuItem=menu.add(0,0,0,"Android");
        {
        menuItem.setIcon(R.drawable.download);
            menuItem.setAlphabeticShortcut('a');
        }
MenuItem menuItem1=menu.add(0,1,1,"Andro");
        {
            menuItem1.setIcon(R.drawable.downloadd);
            menuItem.setAlphabeticShortcut('b');
        }
MenuItem menuItem2=menu.add(0,2,2,"Androi");
        {
            menuItem2.setIcon(R.drawable.downloade);
            menuItem2.setAlphabeticShortcut('c');
        }
MenuItem menuItem3=menu.add(0,3,3,"AndroSuperMan");
        {
            menuItem3.setIcon(R.drawable.downloadf);
            menuItem3.setAlphabeticShortcut('d');
        }
MenuItem menuItem4=menu.add(0,4,4,"AndroDON");
        {
            menuItem4.setIcon(R.drawable.downloadq);
            menuItem4.setAlphabeticShortcut('f');
        }
 }

 private boolean MenuChoice(MenuItem menuItem){
     switch (menuItem.getItemId()){
         case 0:
             Toast.makeText(getApplicationContext(),"You clicked on Item 1",Toast.LENGTH_SHORT).show();
             return true;
         case 1:
             Toast.makeText(getApplicationContext(),"You clicked on Item 2",Toast.LENGTH_SHORT).show();
             return true;
         case 2:
             Toast.makeText(getApplicationContext(),"You clicked on Item 3",Toast.LENGTH_SHORT).show();
             return true;
         case 3:
             Toast.makeText(getApplicationContext(),"You clicked on Item 4",Toast.LENGTH_SHORT).show();
             return true;
         case 4:
             Toast.makeText(getApplicationContext(),"You clicked on Item 5",Toast.LENGTH_SHORT).show();
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

        return MenuChoice(item);
    }
}
