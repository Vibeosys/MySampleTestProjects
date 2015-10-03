package com.example.mahesh.travelapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.OnConnectionFailedListener{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private GoogleMapOptions googleMapOptions;
    private Marker myMarker;
    AutoCompleteTextView text_dest;
    String [] list_dest={"Pune","Hyderabad","Mumbai","Nashik"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        text_dest=(AutoCompleteTextView)findViewById(R.id.dest_text);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_dest);
        text_dest.setAdapter(arrayAdapter);
        text_dest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //int id1=(Integer) parent.getSelectedItem();
                String selection = (String) parent.getItemAtPosition(position);
                int itemId = (int) parent.getId();
                Log.d("ItemId", String.valueOf(itemId));
                // Toast.makeText(getApplicationContext(), ,Toast.LENGTH_SHORT).show();
            }
        });

Button button=(Button)findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Saved Map..", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
      /*  FloatingActionButton fab;
        fab = (FloatingActionButton) findViewById(R.id.fab);

*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        try {
            if (mMap == null) {
                mMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.addCircle(new CircleOptions()
                    .center(new LatLng(21.0000, 78.0000))
                    .radius(100)
                    .strokeColor(Color.RED)
                    .fillColor(Color.BLUE));
            CameraUpdate center=
                    CameraUpdateFactory.newLatLng(new LatLng(18.5203,
                            73.8567));
            CameraUpdate zoom=CameraUpdateFactory.zoomTo(20);

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            Marker marker=  mMap.addMarker(new MarkerOptions().position(new LatLng(18.5203, 73.8567)).title("Pune"));
            Marker marker1=mMap.addMarker(new MarkerOptions().position(new LatLng(12.9667, 77.5667)).title("Banglore"));
            Marker marker2= mMap.addMarker(new MarkerOptions().position(new LatLng(13.0827, 80.2707)).title("Chennai"));
            mMap.addPolyline(new PolylineOptions().geodesic(true)
                    .add(new LatLng(18.5203, 73.8567))  // Pune
                    .add(new LatLng(12.9667, 77.5667))  // Banglore
                    .add(new LatLng(13.0827, 80.2707))  // Mumbai

            );
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker mark) {
                    if(mark.getTitle().equals("Pune")) {
                        CustDialog("Pune");
                        Toast.makeText(MainActivity.this, mark.getTitle(), Toast.LENGTH_SHORT).show();// display toast
                        return true;
                    }
                    if(mark.getTitle().equals("Chennai"))
                    {
                        CustDialog("Chennai");
                        Toast.makeText(MainActivity.this, mark.getTitle(), Toast.LENGTH_SHORT).show();// display toast
                        return true;
                    }
                    if(mark.getTitle().equals("Banglore")){
                        CustDialog("Banglore");
                        Toast.makeText(MainActivity.this, mark.getTitle(), Toast.LENGTH_SHORT).show();// display toast
                        return true;
                    }
                    return false;
                }


            });

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
   /* @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }*/

  void CustDialog(String title){
      // Create custom dialog object
      final Dialog dialog = new Dialog(this);
      // Include dialog.xml file
      dialog.setContentView(R.layout.cust_dialog);
      // Set dialog title
      dialog.setTitle(title);
      Window window = dialog.getWindow();
      window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
      dialog.show();
      RelativeLayout relativeLayout=(RelativeLayout)dialog.findViewById(R.id.item1);
      relativeLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(getApplicationContext(),"View Photos...",Toast.LENGTH_SHORT).show();
          }
      });
      RelativeLayout relativeLayout1=(RelativeLayout)dialog.findViewById(R.id.relativeLayout);
      relativeLayout1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(getApplicationContext(), "View Messages...", Toast.LENGTH_SHORT).show();
          }
      });
  Button sendphoto_button=(Button) dialog.findViewById(R.id.button2);
  Button sendmsg_button=(Button) dialog.findViewById(R.id.button);
  sendmsg_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

Toast.makeText(getApplicationContext(),"Send Msg...",Toast.LENGTH_SHORT).show();
      }
  });
sendphoto_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Send Photo...", Toast.LENGTH_SHORT).show();
    }
});




  }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
     //       mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
          //          .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                //setUpMap();
            }
        }
    }

   /* private void setUpMap() {
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(21.0000, 78.0000))
                .radius(100)
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));
        mMap.addMarker(new MarkerOptions().position(new LatLng(18.5203, 73.8567)).title("Pune"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.9667, 77.5667)).title("Banglore"));


//     mMap.getMyLocation();

    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.nav_manage) {
           Intent intent2=new Intent(getApplicationContext(),ShowRouteList.class);
           startActivity(intent2);

        }
        else if(id==R.id.nav_gallery){
           Intent intent2=new Intent(getApplicationContext(),ShowMyPhotos.class);
           startActivity(intent2);
       }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e("TAG", "onConnectionFailed: ConnectionResult.getErrorCode() = "
                + connectionResult.getErrorCode());

        // TODO(Developer): Check error code and notify the user of error state and resolution.
        Toast.makeText(this,
                "Could not connect to Google API Client: Error " + connectionResult.getErrorCode(),
                Toast.LENGTH_SHORT).show();
    }

}
