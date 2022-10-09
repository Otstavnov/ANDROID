package com.example.lab_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;

public class HelloActivity extends Activity {
    static int x = 0;
    static int y = 0;
    static int i = 0;
    static double f_click = 0;
    static double s_click = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloact);

        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        TextView tx2 = (TextView) findViewById(R.id.txt2);
        TextView tx1 = (TextView) findViewById(R.id.txt1);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);


/*        tx1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                i++;
                if(i==1){
                    f_click = System.currentTimeMillis();
                }
                if (i == 2) {
                    s_click = System.currentTimeMillis();
                    if (0.01 < (s_click - f_click))//Double click
                    {
                        x = 0;
                        //y = 0;
                        tx1.setText(Integer.toString(x));
                        //tx2.setText(Integer.toString(y));
                    }
                    i = 0;
                }
            }
        });*/

        tx2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                i++;
                if(i==1){
                    f_click = System.currentTimeMillis();
                }
                if (i == 2) {
                    s_click = System.currentTimeMillis();
                    if (0.01 < (s_click - f_click))//Double click
                    {
                        x = 0;
                        y = 0;
                        tx1.setText(x);
                        tx2.setText(y);
                    }
                    i = 0;
                }
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                x++;
                tx1.setText(Integer.toString(x));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y++;
                tx2.setText(Integer.toString(y));
            }
        });
    }
}
