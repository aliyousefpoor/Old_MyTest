package com.example.ali.mytest.Activity;

import android.os.Bundle;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;

import com.example.ali.mytest.Fragment.FragmentOne;
import com.example.ali.mytest.Fragment.FragmentThree;
import com.example.ali.mytest.Fragment.FragmentTwo;
import com.example.ali.mytest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SMainActivity extends AppCompatActivity {

    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity_main);
        navigation= (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = FragmentOne.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = FragmentTwo.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = FragmentThree.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, FragmentOne.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }
}