package com.example.ali.mytest.Fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.ali.mytest.R;

public class FragmentOne extends Fragment {

    Button btn3;
    Button btn4;
    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=null;
        view=inflater.inflate(R.layout.fragment_one_layout, container, false);
        btn3 = (Button)view.findViewById(R.id.btn3);
        btn4 = (Button)view.findViewById(R.id.btn4);


        btn3.setOnClickListener(new View.OnClickListener(){

          @Override
           public void onClick(View view) {

              Toast.makeText(getContext(),"clicked Button1",Toast.LENGTH_SHORT).show();

                                    }
        });
        btn4.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"clicked Button2",Toast.LENGTH_SHORT).show();

            }
        });



        return view;





    }
}