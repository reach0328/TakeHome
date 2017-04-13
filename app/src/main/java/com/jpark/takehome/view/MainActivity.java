package com.jpark.takehome.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jpark.takehome.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FragmentManager manager;
    private ListFragment list;
    private RetroFragment retro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();

        list = new ListFragment();
        retro = new RetroFragment();
        manager.beginTransaction().add(R.id.framelayout, list).commit();
    }


    public void listClick(View view){
        manager.beginTransaction().replace(R.id.framelayout, list).commit();
    }

    public void retroClick(View view) {
        manager.beginTransaction().replace(R.id.framelayout, retro).commit();
    }
}
