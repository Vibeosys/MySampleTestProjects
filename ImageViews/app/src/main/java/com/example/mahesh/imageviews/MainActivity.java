package com.example.mahesh.imageviews;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
int [] imageIds={
  R.drawable.download,R.drawable.downloadd,R.drawable.downloadf,R.drawable.downloade,R.drawable.downloadl,R.drawable.downloadq
};
GridView gridView;
ImageSwitcher imageSwitcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridView);
        imageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        gridView.setAdapter(new ImageAdaptor(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  imageSwitcher.setImageResource(imageIds[position]);
            }
        });

    }

    @Override
    public View makeView() {
        ImageView img =new ImageView(this);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img.setMaxHeight(20);
        img.setMaxWidth(20);
        img.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return img;
    }


    public class ImageAdaptor extends BaseAdapter{
    private Context context;
    ImageAdaptor(Context con){
    context=con;
    }

        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
           if(convertView==null) {
               imageView=new ImageView(context);
               imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
               imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
               imageView.setPadding(8, 8, 8, 8);
           }
            else {
               imageView = (ImageView)convertView;
           }
            imageView.setImageResource(imageIds[position]);
            return imageView;
        }
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
