package com.example.mahesh.travelapp;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by mahesh on 10/3/2015.
 */
public class ShowMyPhotos extends AppCompatActivity{
ListView showphoto_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showmyphoto_layout);
        getSupportActionBar();

showphoto_view=(ListView)findViewById(R.id.grid_images);

showphoto_view.setAdapter(new ImageAdapter(this));
    }
    }
class ImageAdapter extends BaseAdapter{
    private Context mContext;
int [] mThumbIds= new int[]{
        R.drawable.eiffeltower, R.drawable.dubaiimage, R.drawable.bridgeimage, R.drawable.beachimg, R.drawable.europeimg, R.drawable.tajimg, R.drawable.ukimg
};

    public int getCount() {
        return mThumbIds.length;
    }
    public Object getItem(int position) {
        return mThumbIds[position];
    }
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        //TextView textView;
        if(convertView==null){
            imageView=new ImageView(mContext);

           // imageView.getLayoutParams().height=30;
            //imageView.getLayoutParams().width=ViewGroup.LayoutParams.WRAP_CONTENT;
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            imageView.setPadding(8, 8, 8, 8);
        }
        else {
            imageView=(ImageView)convertView;
        }
        imageView.requestLayout();
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public ImageAdapter(Context c) {
        mContext = c;
    }


}
