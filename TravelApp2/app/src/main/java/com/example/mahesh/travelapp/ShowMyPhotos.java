package com.example.mahesh.travelapp;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by mahesh on 10/3/2015.
 */
public class ShowMyPhotos extends AppCompatActivity{
ListView showphoto_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showmyphoto_layout);
        getSupportActionBar().setTitle("My Photos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

showphoto_view=(ListView)findViewById(R.id.grid_images);

showphoto_view.setAdapter(new ImageAdapter(this));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    }
class ImageAdapter extends BaseAdapter{
    private Context mContext;
int [] mThumbIds= new int[]{
        R.drawable.eiffeltower, R.drawable.dubaiimage, R.drawable.bridgeimage, R.drawable.beachimg, R.drawable.europeimg, R.drawable.ukimg
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
        FrameLayout frameLayout=new FrameLayout(mContext);
        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView =null;
        ImageView imageView=null;
        //TextView textView;

            imageView=new ImageView(mContext);
            textView =new TextView(mContext);

           // imageView.getLayoutParams().height=30;
            //imageView.getLayoutParams().width=ViewGroup.LayoutParams.WRAP_CONTENT;
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            textView.setText("Created on 15-12-2015");
            textView.setPadding(30,30,30,30);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setImageResource(mThumbIds[position]);
        // imageView.requestLayout();


        frameLayout.addView(imageView);
        frameLayout.addView(textView);
        return frameLayout;
    }

    public ImageAdapter(Context c) {
        mContext = c;
    }


}
