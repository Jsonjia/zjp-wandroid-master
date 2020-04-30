package com.zjp.main;


import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.main.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
