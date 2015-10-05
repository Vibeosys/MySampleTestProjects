package com.example.mahesh.travelapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahesh on 10/3/2015.
 */
public class ShowRouteList extends AppCompatActivity {
    ListView listView;
    String [] from=new String[]{"Mumbai","Pune","Banglore","Chennai"};
    String [] to=new String[]{"Pune","Mumbai","Chennai","Banglore"};
    List<TextView> list=new ArrayList<TextView>(from.length);
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routelist_layout);
        getSupportActionBar().setTitle("My Routes");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView=(ListView)findViewById(R.id.routelistview);
        listView.setAdapter(new TravelCustomAdaptor(from, to));
       context=getApplicationContext();
       // HorizentalScrollView hp=new HorizentalScrollView(context);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //   Toast.makeText(getApplicationContext(), "My", Toast.LENGTH_SHORT).show();
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
       // LinearLayout linearLayout=new LinearLayout(context);
        //linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        row = inflater.inflate(R.layout.cust_routes, parent, false);
        //LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //layoutParams.weight=1;
       // ImageView imageView=new ImageView(context);
      //  imageView.setImageResource(R.drawable.arroyicon);
        TextView title, detail;
       // title=new TextView(context);
     //   detail=new TextView(context);
        //title.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //title.setPadding(20, 20, 20, 20);
        //title.setGravity(Gravity.CENTER_VERTICAL);
        //title.setPadding(0, 0, 0, 30);
        //title.setTypeface(null, Typeface.BOLD);
        //title.setTextSize(17);
        // detail.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50));
        //imageView.setLayoutParams(new ViewGroup.LayoutParams(25,25));

         title = (TextView) row.findViewById(R.id.item_title);
        detail = (TextView) row.findViewById(R.id.to_destination);
        //i1=(ImageView)row.findViewById(R.id.img);

       //   title.setText(dest_from[position]);
       /* for(int i=0;i<=3;i++){
            appendText(title, dest_from[i]);
            if(i<3) appendDrawable(title,R.drawable.ic_trending_flat_black_24dp);

        }
       */     detail.setText(dest_to[position]);
        for(int i=0;i<dest_to.length;i++){
            detail.append(dest_to[i] + "\t"+" TO ");
         //   detail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arroyicon, 0, R.drawable.arroyicon, 0);
        //    Log.d("TO", dest_to[i]);
        }

        //i1.setImageResource(imge[position]);
      //  linearLayout.addView(title);
//        linearLayout.addView(imageView);
       // linearLayout.addView(detail);
        return row;

    }
}

    private void appendText(TextView textView1,String s){
textView1.append(s);
    }
    private void appendDrawable(TextView title, int application) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        String THREE_SPACES = "   ";
        builder.append(THREE_SPACES);
        Drawable drawable = getResources().getDrawable(application);
        assert drawable != null;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan image = new ImageSpan(drawable);
        builder.setSpan(image, 1, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.append(builder);
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
