package com.example.mahesh.travelapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mahesh on 10/3/2015.
 */
public class ShowRouteList extends Activity {
    ListView listView;
    String [] from=new String[]{"Mumbai","Pune","Banglore","Chennai"};
    String [] to=new String[]{"Pune","Mumbai","Chennai","Banglore"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routelist_layout);
        listView=(ListView)findViewById(R.id.routelistview);
        listView.setAdapter(new TravelCustomAdaptor(from,to));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "My", Toast.LENGTH_SHORT).show();
            }
        });
    }
class TravelCustomAdaptor extends BaseAdapter{
String dest_from[];String dest_to[];
    TravelCustomAdaptor(String t[],String[] v){
        dest_from=t;
        dest_to=v;
    }
    @Override
    public int getCount() {
        return dest_from.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = getLayoutInflater();
        View row;
        row = inflater.inflate(R.layout.cust_routes, parent, false);
        TextView title, detail;
        //ImageView i1;
        title = (TextView) row.findViewById(R.id.item_title);
        detail = (TextView) row.findViewById(R.id.to_destination);
        //i1=(ImageView)row.findViewById(R.id.img);
        title.setText(dest_from[position]);
        detail.setText(dest_to[position]);
        //i1.setImageResource(imge[position]);

        return (row);

    }
}
}
