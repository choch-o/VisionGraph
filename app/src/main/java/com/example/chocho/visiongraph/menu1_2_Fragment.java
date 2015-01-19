package com.example.chocho.visiongraph;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.example.chocho.visiongraph.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by chocho on 2015-01-07.
 */
public class menu1_2_Fragment extends Fragment {
    View rootview;
    View.OnClickListener ocl;
    //public static final String Answer1 = "a1Key";
    //Context context = getActivity();
    //SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_2_layout, container, false);
/*        ImageButton btn1 = (ImageButton)rootview.findViewById(R.id.edit_button1);
        ImageButton btn2 = (ImageButton)rootview.findViewById(R.id.edit_button2);
        ImageButton btn3 = (ImageButton)rootview.findViewById(R.id.edit_button3);
        btn1.setBackground(null);
        btn2.setBackground(null);
        btn3.setBackground(null);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);*/
        //final EditView answer1 = (EditView) rootview.findViewById(R.id.my_vision1_answer);
        //final EditText answer2 = (EditText) rootview.findViewById(R.id.my_vision2_answer);
        //final EditText answer3 = (EditText) rootview.findViewById(R.id.my_vision3_answer);
        /*
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Answer1, answer1.getText().toString());

        if (savedInstanceState != null) {
            answer1.setText(savedInstanceState.getString("answer1"));
        }
        */
        return rootview;
    }
/*
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), editActivity.class);
        startActivity(intent);
        switch (view.getId()) {
            case R.id.edit_button1:
                break;
            case R.id.edit_button2:
                break;
            case R.id.edit_button3:
                break;
        }
    }
    */
    /*
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        EditView answer1 = (EditView)getActivity().findViewById(R.id.my_vision1_answer);
        String a1 = answer1.getText();
        outState.putString("answer1", a1);
    }
    */
}
