package com.nextstacks.toolbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private String[] titles = new String[] {"Chats",  "Status", "Calls"};

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Bundle arguments = new Bundle();
        switch (position){
            case 1:
                fragment = new TestFragment();
                arguments.putString("TITLE", "Status Fragment");
                fragment.setArguments(arguments);
                break;

            case 2:
                fragment = new TestFragment();
                arguments.putString("TITLE", "Calls Fragment");
                fragment.setArguments(arguments);
                break;

            default:
                fragment = new TestFragment();
                arguments.putString("TITLE", "Chat Fragment");
                fragment.setArguments(arguments);
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
