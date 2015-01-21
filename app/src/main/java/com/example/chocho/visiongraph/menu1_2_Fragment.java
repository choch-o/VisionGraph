package com.example.chocho.visiongraph;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.example.chocho.visiongraph.R;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by chocho on 2015-01-07.
 */
public class menu1_2_Fragment extends Fragment implements View.OnClickListener{
    View rootview;
    View.OnClickListener ocl;
    String content;

    TextView answerText1;
    TextView answerText2;
    TextView answerText3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_2_layout, container, false);
        ImageButton btn1 = (ImageButton)rootview.findViewById(R.id.edit_button1);
        ImageButton btn2 = (ImageButton)rootview.findViewById(R.id.edit_button2);
        ImageButton btn3 = (ImageButton)rootview.findViewById(R.id.edit_button3);
        btn1.setBackground(null);
        btn2.setBackground(null);
        btn3.setBackground(null);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        answerText1 = (TextView) rootview.findViewById(R.id.my_vision1_answer);
        answerText2 = (TextView) rootview.findViewById(R.id.my_vision2_answer);
        answerText3 = (TextView) rootview.findViewById(R.id.my_vision3_answer);

        try{
            FileInputStream fis = getActivity().openFileInput("answer1.txt");
            byte[] data = new byte[fis.available()];
            while (fis.read(data) != -1) {}
            fis.close();
            answerText1.setText(new String(data));
        } catch (FileNotFoundException e) {
            answerText1.setText("");
        } catch (Exception e) {}

        try{
            FileInputStream fis2 = getActivity().openFileInput("answer2.txt");
            byte[] data2 = new byte[fis2.available()];
            while (fis2.read(data2) != -1) {}
            fis2.close();
            answerText2.setText(new String(data2));
        } catch (FileNotFoundException e) {
            answerText2.setText("");
        } catch (Exception e) {}

        try{
            FileInputStream fis3 = getActivity().openFileInput("answer3.txt");
            byte[] data3 = new byte[fis3.available()];
            while (fis3.read(data3) != -1) {}
            fis3.close();
            answerText3.setText(new String(data3));
        } catch (FileNotFoundException e) {
            answerText3.setText("");
        } catch (Exception e) {}
        return rootview;
    }

    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), editActivity.class);
        switch (view.getId()) {
            case R.id.edit_button1:
                try{
                    FileInputStream fis = getActivity().openFileInput("answer1.txt");
                    byte[] d = new byte[fis.available()];
                    while (fis.read(d) != -1) {}
                    fis.close();
                    intent.putExtra("num", 1);
                    intent.putExtra("content", new String(d));
                    startActivityForResult(intent, 1);
                } catch (FileNotFoundException e) {
                } catch (Exception e) {}

                break;
            case R.id.edit_button2:
                try{
                    FileInputStream fis = getActivity().openFileInput("answer2.txt");
                    byte[] d2 = new byte[fis.available()];
                    while (fis.read(d2) != -1) {}
                    fis.close();
                    intent.putExtra("num", 2);
                    intent.putExtra("content", new String(d2));
                    startActivityForResult(intent, 1);
                } catch (FileNotFoundException e) {
                } catch (Exception e) {}

                break;
            case R.id.edit_button3:
                try{
                    FileInputStream fis = getActivity().openFileInput("answer3.txt");
                    byte[] d3 = new byte[fis.available()];
                    while (fis.read(d3) != -1) {}
                    fis.close();
                    intent.putExtra("num", 3);
                    intent.putExtra("content", new String(d3));
                    startActivityForResult(intent, 1);
                } catch (FileNotFoundException e) {
                } catch (Exception e) {}

                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                content = data.getStringExtra("content");
                int num = (int) data.getIntExtra("num", 0);
                switch (num) {
                    case 1:
                        try {
                            FileOutputStream fos = getActivity().openFileOutput("answer1.txt", Context.MODE_WORLD_READABLE);
                            fos.write(content.getBytes());
                            fos.close();
                            answerText1.setText(content);
                        } catch (Exception e) {}
                        break;
                    case 2:
                        try {
                            FileOutputStream fos = getActivity().openFileOutput("answer2.txt", Context.MODE_WORLD_READABLE);
                            fos.write(content.getBytes());
                            fos.close();
                            answerText2.setText(content);
                        } catch (Exception e) {}
                        break;
                    case 3:
                        try {
                            FileOutputStream fos = getActivity().openFileOutput("answer3.txt", Context.MODE_WORLD_READABLE);
                            fos.write(content.getBytes());
                            fos.close();
                            answerText3.setText(content);
                        } catch (Exception e) {}
                        break;
                }
                //answer.setContent(answerText.getText().toString());
                //MainActivity.db.updateAnswer(answer);
                //answerText.setText(content);
            }
        }
    }

}
