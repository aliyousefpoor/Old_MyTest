package com.example.ali.mytest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ali.mytest.R;

/**
 * Created by Ali on 7/23/2017.
 */

public class SecondActivity extends AppCompatActivity {

    Button carbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        carbtn = (Button)findViewById(R.id.carbtn);

        carbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
        });
    }
}
