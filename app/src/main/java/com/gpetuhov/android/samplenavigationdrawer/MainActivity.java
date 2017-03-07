package com.gpetuhov.android.samplenavigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // ListView for menu items
    @BindView(R.id.left_drawer) ListView mDrawerList;

    // Keeps menu titles
    private String[] mMenuTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind views
        ButterKnife.bind(this);

        // Get menu item titles
        mMenuTitles = getResources().getStringArray(R.array.menu_item_titles);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, mMenuTitles));

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
