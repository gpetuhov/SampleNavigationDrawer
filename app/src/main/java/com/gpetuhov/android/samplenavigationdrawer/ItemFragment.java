package com.gpetuhov.android.samplenavigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

// Fragment for all navigation menu items
public class ItemFragment extends Fragment {

    // Key for item number in the fragment's arguments
    private static final String ARG_MENU_ITEM = "arg_menu_item";

    // Displays item title
    @BindView(R.id.item_title) TextView mItemTitle;

    // Keeps ButterKnife Unbinder object to properly unbind views in onDestroyView of the fragment
    private Unbinder mUnbinder;

    // Return new instance of this fragment and attach arguments to it
    public static ItemFragment newInstance(int position) {

        // Create new empty Bundle object for fragment arguments
        Bundle args = new Bundle();

        // Put earthquake ID into Bundle object
        args.putInt(ARG_MENU_ITEM, position);

        // Create new instance of this fragment
        ItemFragment fragment = new ItemFragment();

        // Attach arguments to fragment
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_item, container, false);

        // Bind views and save reference to Unbinder object
        mUnbinder = ButterKnife.bind(this, v);

        // Get menu item position from the fragment's arguments
        int position = getArguments().getInt(ARG_MENU_ITEM);

        // Get menu item titles
        String[] menuTitles = getResources().getStringArray(R.array.menu_item_titles);

        // Set item title according to chosen position in the menu
        mItemTitle.setText(menuTitles[position]);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // This is recommended to do here when using Butterknife in fragments
        mUnbinder.unbind();
    }
}
