package com.example.mahesh.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by mahesh on 10/5/2015.
 */
public class HorizentalScrollView extends BaseAdapter {
    String [] from=new String[]{"Mumbai","Pune","Banglore","Chennai"};
    String [] to=new String[]{"Pune","Mumbai","Chennai","Banglore"};
    LayoutInflater layoutInflater;
    Context context;
    HorizentalScrollView(Context context1){
        context=context1;
    }
    @Override
    public int getCount() {
        return from.length;
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

        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=convertView;
        TextView textView = null;
        if(view==null) {
            view = layoutInflater.inflate(R.layout.horizental_routes_layout,parent,false);
            textView= (TextView) view.findViewById(R.id.item_title);
        }
        textView.setText(from[position]);
        return view;
    }

}
