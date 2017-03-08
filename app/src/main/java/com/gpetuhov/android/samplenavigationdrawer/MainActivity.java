package com.gpetuhov.android.samplenavigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Drawer layout
    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;

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

        // Add first item fragment to activity
        loadFragment(0);

        // Get menu item titles
        mMenuTitles = getResources().getStringArray(R.array.menu_item_titles);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, mMenuTitles));

        mDrawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
    }

    private void loadFragment(int position) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = ItemFragment.newInstance(position);
        fm.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }

    private void selectItem(int position) {
        // Add fragment to activity according to selected position
        loadFragment(position);

        // Highlight the selected item and close the drawer
        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }
}
