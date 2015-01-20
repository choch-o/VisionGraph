package com.example.chocho.visiongraph;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by chocho on 2015-01-19.
 */
public class editActivity extends Activity {
    String content;
    String savedContent;
    EditText answerText;
    int num;
    Intent intent = new Intent();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editactivity);
        num = (int) getIntent().getIntExtra("num", 0);
        answerText = (EditText) findViewById(R.id.editBox);
        savedContent = getIntent().getStringExtra("content");
        answerText.setText(savedContent);
        Button doneBtn = (Button) findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                content = answerText.getText().toString();
                intent.putExtra("content", content);
                intent.putExtra("num", num);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
