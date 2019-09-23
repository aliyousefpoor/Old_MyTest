package com.example.ali.mytest.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ali.mytest.R;

/**
 * Created by Ali on 7/13/2017.
 */

public class Info extends AppCompatActivity {

    TextView txt;
    TextView txtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        txt = (TextView) findViewById(R.id.txt);
        txtt = (TextView) findViewById(R.id.txtt);
        txt.setText(getIntent().getExtras().getString("thetext"));
        txtt.setText(getIntent().getExtras().getString("thetextt"));
    }
}
