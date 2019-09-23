package com.example.ali.mytest.Fragment;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.ali.mytest.Activity.Info;
import com.example.ali.mytest.R;

public class FragmentFour extends Fragment {
    EditText txt;
    EditText txtt;
    Button btn5;

    public static FragmentFour newInstance() {
        FragmentFour fragment = new FragmentFour();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_four_layout, container, false);
        btn5 = (Button)view.findViewById(R.id.btn5);
        txt = (EditText)view.findViewById(R.id.txt);
        txtt=(EditText)view.findViewById(R.id.txtt);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Info.class);
                intent.putExtra("thetext", txt.getText().toString());
                intent.putExtra("thetextt", txtt.getText().toString());


                if (txt.getText().toString().isEmpty()) {

                    txt.setError("This field can not be empty");
                } else {

                    startActivity(intent);
                }

            }
        });




        return view;
    }
}