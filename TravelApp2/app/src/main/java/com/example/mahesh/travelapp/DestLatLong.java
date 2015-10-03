package com.example.mahesh.travelapp;

/**
 * Created by mahesh on 10/3/2015.
 */
public class DestLatLong {
private double latitude;
private double longitude;
DestLatLong(){

}
    DestLatLong(double lat,double longi){
        latitude=lat;
        longitude=longi;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }




}
