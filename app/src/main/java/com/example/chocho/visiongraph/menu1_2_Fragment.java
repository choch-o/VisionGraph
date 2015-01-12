package com.example.chocho.visiongraph;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by chocho on 2015-01-07.
 */
public class menu1_2_Fragment extends Fragment {
    View rootview;
    /*TextView answer1;
    TextView answer2;
    TextView answer3;
    public static final String Answer1 = "a1Key";
    //Context context = getActivity();
    //SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_2_layout, container, false);
        /*
        answer1 = (TextView) getView().findViewById(R.id.my_vision1_answer);
        answer2 = (TextView) getView().findViewById(R.id.my_vision2_answer);
        answer3 = (TextView) getView().findViewById(R.id.my_vision3_answer);
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Answer1, answer1.getText().toString());
        */
        return rootview;
    }
}
