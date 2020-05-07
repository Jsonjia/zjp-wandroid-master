package com.zjp.main;


import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.main.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> implements  BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
