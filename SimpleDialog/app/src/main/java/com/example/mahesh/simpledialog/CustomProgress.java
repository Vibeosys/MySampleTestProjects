package com.example.mahesh.simpledialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by mahesh on 9/19/2015.
 */
public class CustomProgress extends DialogFragment {
ProgressDialog progressDialog;
    static CustomProgress newInstance(){
        return new CustomProgress();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
ProgressDialog progressDialog=new ProgressDialog(getActivity());
progressDialog.setTitle("Downloading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return progressDialog;
    }

}
