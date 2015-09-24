package com.example.mahesh.pickers;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by mahesh on 9/24/2015.
 */
public class ShowListView extends ListActivity{
    String [] countries;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listView=getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        countries=getResources().getStringArray(R.array.country);
       // ArrayAdapter<String> arrayAdapter;
       // arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strings);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, countries));

    }

    @Override
    protected void onListItemClick(ListView lstView, View v, int position, long id) {
        Toast.makeText(getApplicationContext(),countries[position],Toast.LENGTH_SHORT).show();
        String itemsSelected="selected items :\n";
        for (int i=0; i<lstView.getCount(); i++) {
            if (lstView.isItemChecked(i)) {
                itemsSelected += lstView.getItemAtPosition(i)+"\n";
            }
        }
        Toast.makeText(this, itemsSelected, Toast.LENGTH_LONG).show();
        super.onListItemClick(lstView, v, position, id);

    }

}
