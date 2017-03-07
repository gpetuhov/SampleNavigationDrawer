package com.gpetuhov.android.samplenavigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add first item fragment to activity
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.content_frame);
        if (null == fragment) {
            fragment = ItemFragment.newInstance(0);
            fm.beginTransaction()
                    .add(R.id.content_frame, fragment)
                    .commit();
        }
    }
}
