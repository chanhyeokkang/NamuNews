package com.ck.namunews;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentStateAdapter {
    private final int NUM_PAGES = 7;
    private ArrayList<NewsDTO> data;

    public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<NewsDTO> data) {
        super(fragmentActivity);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return MyFragment.newInstance(data);
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}