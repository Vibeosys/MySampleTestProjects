package com.example.mahesh.simplefragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mahesh on 9/21/2015.
 */

public class Fragment1 extends Fragment {
    public interface CallActivity{
        public void getData(String s);
    }

    CallActivity callActivity;

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try {
            callActivity = (CallActivity) context;
            Log.d("OnAttach", "OnAttach is called....");
        }catch (ClassCastException e){
           throw new ClassCastException("must implement "+context.toString());
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("OnCreate", "OnCreate is called....");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("OnActivityCreated", "OnActivityCreated is called....");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("OnStop","OnStop is called....");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("OnDestroyView", "OnDestroyView is called....");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("OnPause", "OnPause is called....");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("OnDetach", "OnDetach is called....");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("OnStart", "OnStart is called....");
        Button button= (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText)getActivity().findViewById(R.id.editText);
                TextView textView=(TextView)getActivity().findViewById(R.id.text);
                if(editText.getText().toString()!=null&&editText.getText().toString().length()>0) {
                    Toast.makeText(getActivity(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                    textView.setText(editText.getText().toString());
                    String temp=editText.getText().toString();
                    callActivity.getData(temp);
                }
                else{
                    editText.setError("Enter valid data");
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("OnCreateView","OnCreateView is called....");
        return inflater.inflate(R.layout.fragment1,container,false);

    }
}
