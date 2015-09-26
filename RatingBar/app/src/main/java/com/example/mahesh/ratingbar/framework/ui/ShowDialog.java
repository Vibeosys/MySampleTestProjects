package com.example.mahesh.ratingbar.framework.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.mahesh.ratingbar.controller.MainActivity;
import com.example.mahesh.ratingbar.R;

/**
 * Created by mahesh on 9/26/2015.
 */
public class ShowDialog extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.show_dialog,container);
        getDialog().setTitle("Give Feedback");
        RatingBar ratingBar= (RatingBar) (RatingBar) view.findViewById(R.id.ratingBar2);
        Button button1=(Button)view.findViewById(R.id.button3);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((MainActivity)getActivity()).Rate(rating);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).dismissDialog();
            }
        });
        return view;
    }
}
