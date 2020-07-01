package com.zjp.common.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.zjp.common.callback.TabPagerListener;

import java.util.List;

/**
 * Created by zjp on 2020/7/1 0001 11:14
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int PAGE_COUNT;
    public TabPagerListener listener;

    public TabPagerAdapter(@NonNull FragmentManager fm, int count) {
        super(fm);
        this.PAGE_COUNT = count;
    }

    public void setListener(TabPagerListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listener.getFragment(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
