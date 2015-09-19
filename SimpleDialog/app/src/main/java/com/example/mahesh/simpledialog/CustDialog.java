package com.example.mahesh.simpledialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.NonNull;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.widget.Toast;

class CustDialog extends DialogFragment {
    public CustDialog() {
          // Empty constructor required for DialogFragment
    }

    public static CustDialog newInstance(String title) {
        CustDialog frag = new CustDialog();

        return frag;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
         final String [] str=new String[]{"Google","Yahoo","Bing"};
        //boolean[] itemschecked=new boolean[items.length];
         AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Hi");
         //alertDialogBuilder.setMessage("Are you sure?");
alertDialogBuilder.setItems(str, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
Toast.makeText(getActivity(),str[which]+" is Clicked",Toast.LENGTH_SHORT).show();
    }
});
       alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Toast.makeText(getActivity(), "Yes button clicked", Toast.LENGTH_SHORT).show();
           }
       });
         alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Toast.makeText(getActivity(), "No button clicked", Toast.LENGTH_SHORT).show();
                 dialog.dismiss();
             }
         });



         return alertDialogBuilder.create();
    }
}