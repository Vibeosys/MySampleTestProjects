package com.example.mahesh.viewpagerapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mahesh on 9/29/2015.
 */
public class NavDrawerListAd extends BaseAdapter {
Context context1;
    ArrayList<NavDrawerItem> arrayList;
    NavDrawerListAd(Context context,ArrayList<NavDrawerItem> NavDrawer ){
context1=context;
        arrayList=NavDrawer;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context1.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

        imgIcon.setImageResource(arrayList.get(position).getIcon());
        txtTitle.setText(arrayList.get(position).getTitle());

        // displaying count
        // check whether it set visible or not
        if(arrayList.get(position).getCounterVisibility()){
            txtCount.setText(arrayList.get(position).getCount());
        }else{
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }

        return convertView;

    }
}
