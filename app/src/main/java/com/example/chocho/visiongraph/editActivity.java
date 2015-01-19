package com.example.chocho.visiongraph;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by chocho on 2015-01-19.
 */
public class editActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editactivity);
        Button doneBtn = (Button) findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
