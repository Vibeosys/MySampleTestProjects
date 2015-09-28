package com.example.mahesh.consumerest;

/**
 * Created by mahesh on 9/28/2015.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*
*  Utility class for network related operations
* */
public class NetworkUtils {

    /* Method to check network availability
    * */
    public boolean isActiveNetworkAvailable(Context aContext){

        boolean theStatus = false;
        ConnectivityManager theConManager = (ConnectivityManager)aContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo theNetInfo = theConManager.getActiveNetworkInfo();
        if(theNetInfo != null) {
            theStatus = theNetInfo.isConnected();
        }
        return theStatus;

    }

}

