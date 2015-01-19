package com.example.chocho.visiongraph;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by chocho on 2015-01-07.
 */

public class menu2_Fragment extends Fragment {
    int chk = 0;
    View rootview;
    TextView textView;
    FrameLayout frameLayout;
    int width = 0, height = 0;
    float x_axis = 0, y_axis = 0;
    float y_axis_width, y_axis_height;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu2_layout, container, false);
        //mainView = (View)rootview.findViewById(R.id.upperSite);

        if(chk == 0) {
            chk = 1;
            rootview.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    Log.w("a", "b");
                    width = rootview.getMeasuredWidth();
                    height = rootview.getMeasuredHeight();
                    y_axis = width / 16;
                    x_axis = height / 2;
                    y_axis_width = y_axis * 2;
                    y_axis_height = (height - 20) / 21;

                    frameLayout = (FrameLayout) rootview.findViewById(R.id.container);
                    frameLayout.addView(new axis(getActivity()));

                    textView = new TextView(getActivity());
                    textView.setWidth((int)y_axis_width);
                    textView.setHeight((int)y_axis_height);
                    textView.setPadding((int)y_axis, (int)x_axis, 0, 0);
                    textView.setTextSize(10);
                    textView.setText("나이");
                    textView.setTextColor(Color.BLACK);
                    frameLayout.addView(textView);

                    //y-axis text
                    for (int i = 0; i <= 20; i++) {
                        textView = new TextView(getActivity());
                        textView.setWidth((int)y_axis_width);
                        textView.setHeight((int)y_axis_height);
                        textView.setPadding(10, 25 + (int)y_axis_height * i, 0, 0);
                        //textView.setGravity(Gravity.CENTER);
                        textView.setTextSize(10);
                        if(i >= 10) textView.setText(String.valueOf(i - 10));
                        else textView.setText(String.valueOf(10 - i));
                        textView.setTextColor(Color.BLACK);
                        frameLayout.addView(textView);
                    }

                    //x-axis text
                    for (int i = 0; i <= 9; i++) {
                        textView = new TextView(getActivity());
                        textView.setWidth((int)y_axis_width);
                        textView.setHeight((int)y_axis_height);
                        if(i == 0) textView.setPadding((int)(y_axis * 2 + y_axis * 14 / 10 * i), (int)x_axis + 5, 0, 0);
                        else textView.setPadding((int)(y_axis * 2 + y_axis * 14 / 10 * i - 10), (int)x_axis + 5, 0, 0);
                        textView.setTextSize(10);
                        textView.setText(String.valueOf(i * 10));
                        textView.setTextColor(Color.BLACK);
                        frameLayout.addView(textView);
                    }
                }
            });
        }
        
        return rootview;
    }

    private class axis extends View{
        Paint paint = new Paint();

        public axis(Context context) {
            super(context);
        }
        @Override
        public void onDraw(Canvas canvas) {

            paint.setColor(Color.parseColor("#D0D0D0"));
            paint.setStrokeWidth(3);

            //x-axis, y-axis
            canvas.drawLine(y_axis, x_axis, width, x_axis, paint);
            canvas.drawLine(y_axis * 2, 0, y_axis * 2, height, paint);

            //evnet_point
            //10 years, 5 point
            int n = 29;
            int[] years = new int[n];
            int[] point = new int[n];

            /*years[0] = 10; point[0] = 5;
            years[1] = 15; point[1] = -5;
            years[2] = 30; point[2] = 10;
            years[3] = 50; point[3] = 9;
            years[4] = 90; point[4] = 0;*/
            years[0] = 10; point[0] = 0;
            years[1] = 10; point[1] = 1;
            years[2] = 10; point[2] = 2;
            years[3] = 10; point[3] = 3;
            years[4] = 10; point[4] = 4;
            years[5] = 10; point[5] = 5;
            years[6] = 10; point[6] = 6;
            years[7] = 10; point[7] = 7;
            years[8] = 10; point[8] = 8;
            years[9] = 10; point[9] = 9;
            years[10] = 10; point[10] = 10;
            years[11] = 10; point[11] = -1;
            years[12] = 10; point[12] = -2;
            years[13] = 10; point[13] = -3;
            years[14] = 10; point[14] = -4;
            years[15] = 10; point[15] = -5;
            years[16] = 10; point[16] = -6;
            years[17] = 10; point[17] = -7;
            years[18] = 10; point[18] = -8;
            years[19] = 10; point[19] = -9;
            years[20] = 10; point[20] = -10;
            years[21] = 20; point[21] = 0;
            years[22] = 30; point[21] = 0;
            years[23] = 40; point[21] = 0;
            years[24] = 50; point[21] = 0;
            years[25] = 60; point[21] = 0;
            years[26] = 70; point[21] = 0;
            years[27] = 80; point[21] = 0;
            years[28] = 90; point[21] = 0;

            paint.setColor(Color.parseColor("#FF0000"));

            for(int i = 0 ; i < n ; i ++ ) {
                canvas.drawCircle(y_axis * 2 + y_axis * 14 / 100 * years[i], x_axis - point[i] * y_axis_height, 3, paint);
            }
        }
    }
}