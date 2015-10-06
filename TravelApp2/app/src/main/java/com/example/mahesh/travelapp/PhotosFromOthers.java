package com.example.mahesh.travelapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by mahesh on 10/6/2015.
 */
public class PhotosFromOthers extends AppCompatActivity {
   ListView other_photo_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherphotolist);
        other_photo_list=(ListView)findViewById(R.id.otherlistView);
        other_photo_list.setAdapter(new ShowListAdaptor(getApplicationContext()));


    }

}
class ShowListAdaptor extends BaseAdapter{
    Context mcontext;
ShowListAdaptor(Context context){
    mcontext=context;
}

    int [] mThumbIds= new int[]{
            R.drawable.eiffeltower, R.drawable.dubaiimage, R.drawable.bridgeimage, R.drawable.beachimg, R.drawable.europeimg, R.drawable.ukimg
    };
    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        Log.d("GetItem Returned..",String.valueOf(position));
        return position;
    }

    @Override
    public long getItemId(int position) {
        Log.d("GetItemId Returned..",String.valueOf(position));
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.otherphotos,parent,false);
        ImageView photo=null;
        TextView user=null;


        photo=(ImageView)view.findViewById(R.id.otherphotoview);
        user=(TextView)view.findViewById(R.id.user_text);

        user.setText("Mahesh Giri");
        photo.setImageResource(mThumbIds[position]);
        return view;
    }

}