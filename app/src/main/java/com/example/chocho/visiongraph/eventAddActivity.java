package com.example.chocho.visiongraph;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class eventAddActivity extends ActionBarActivity {
    Button addButton;
    EditText addName, addAge, addScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addButton = (Button)findViewById(R.id.eventAddButton);
        addName = (EditText)findViewById(R.id.event_name);
        addAge = (EditText)findViewById(R.id.event_age);
        addScore = (EditText)findViewById(R.id.event_score);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addName.equals("") == false) {
                    if(addAge.equals("") == false) {
                        if(addScore.equals("") == false) {

                            MainActivity.ddbbEventName[ ++ MainActivity.ddbbEventCnt ] = addName.getText().toString();
                            MainActivity.ddbbEventAge[ MainActivity.ddbbEventCnt ] = Integer.parseInt(addAge.getText().toString());
                            MainActivity.ddbbEventScore[ MainActivity.ddbbEventCnt ] = Integer.parseInt(addScore.getText().toString());

                            Intent intent = new Intent(eventAddActivity.this, MainActivity.class);
                            startActivity(intent);
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

        setContentView(R.layout.activity_event_add);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
