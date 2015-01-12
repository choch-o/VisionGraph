package com.example.chocho.visiongraph;

import android.content.Context;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by chocho on 2015-01-12.
 */
public class EditView extends LinearLayout {
    @SuppressWarnings("unused")
    private Context mContext;
    private ImageView mEditButton;
    private TextView mTextView;
    private EditText mEditText;

    private  View.OnClickListener mEditButtonOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if(mTextView.getVisibility() == View.VISIBLE){
                enableEdit();
            }else{
                disableEdit();
            }
        }
    };

    public EditView(Context context) {
        super(context);
        init(context);
    }

    public EditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        this.mContext = context;
        View.inflate(context, R.layout.edit_view, this);

        mTextView 	= (TextView)findViewById(R.id.text_view);
        mEditText 	= (EditText)findViewById(R.id.edit_text);
        mEditButton = (ImageView)findViewById(R.id.edit_button);
        mEditButton.setOnClickListener(mEditButtonOnClick);

        mTextView.setText("");
        mEditText.setText("");
    }

    public void setHint(String hint){
        mEditText.setHint(hint);
        mTextView.setHint(hint);
    }

    public void setText(String text){
        mEditText.setText(text);
        mTextView.setText(text);
    }

    public String getText(){
        if(mEditText.getVisibility() == View.VISIBLE)
            return mEditText.getText().toString();
        else
            return mTextView.getText().toString();
    }

    public void enableEdit(){
        mEditText.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.GONE);
        mEditText.setText(mTextView.getText());
        mEditText.requestFocus();
    }

    public void disableEdit(){
        mEditText.setVisibility(View.GONE);
        mTextView.setVisibility(View.VISIBLE);
        mTextView.setText(mEditText.getEditableText().toString());
    }

    public void hideEditButton(){
        mEditButton.setVisibility(View.GONE);
    }

    public void showEditButton(){
        mEditButton.setVisibility(View.VISIBLE);
    }

    public boolean isEditEnabled(){
        return mEditText.getVisibility() == View.VISIBLE ? true:false;
    }

    public void setEditButtonOnClickListener(View.OnClickListener l){
        mEditButton.setOnClickListener(l);
    }

    public void enableScrolling(){
        mTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void addTextChangedListener(TextWatcher ctx){
        mEditText.addTextChangedListener(ctx);
    }
}
