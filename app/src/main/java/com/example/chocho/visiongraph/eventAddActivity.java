package com.example.chocho.visiongraph;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class eventAddActivity extends Activity {
    Button addButton2;
    EditText addName, addAge, addScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_add);

        addButton2 = (Button) findViewById(R.id.eventAddButton);
        addName = (EditText) findViewById(R.id.event_name);
        addAge = (EditText) findViewById(R.id.event_age);
        addScore = (EditText) findViewById(R.id.event_score);

        addButton2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Log.w("add - ", "in");
                if(addName.getText().toString().equals("") == false) {
                    if(addAge.getText().toString().equals("") == false) {
                        if(addScore.getText().toString().equals("") == false) {

                            MainActivity.ddbbEventName[ ++ MainActivity.ddbbEventCnt ] = addName.getText().toString();
                            MainActivity.ddbbEventAge[ MainActivity.ddbbEventCnt ] = Integer.parseInt(addAge.getText().toString());
                            MainActivity.ddbbEventScore[ MainActivity.ddbbEventCnt ] = Integer.parseInt(addScore.getText().toString());

                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                        else {
                            AlertDialog.Builder alertDlg = new AlertDialog.Builder(v.getContext());

                            alertDlg.setMessage("점수를 입력하세요!");
                            alertDlg.show();
                        }
                    }
                    else {
                        AlertDialog.Builder alertDlg = new AlertDialog.Builder(v.getContext());

                        alertDlg.setMessage("나이를 입력하세요!");
                        alertDlg.show();
                    }
                }
                else {
                    AlertDialog.Builder alertDlg = new AlertDialog.Builder(v.getContext());

                    alertDlg.setMessage("이름을 입력하세요!");
                    alertDlg.show();
                }
            }
        });
    }
}
