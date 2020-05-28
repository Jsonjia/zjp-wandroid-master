package com.zjp.home.activity;

import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.home.R;
import com.zjp.home.databinding.ActivitySearchBinding;

/**
 * Created by zjp on 2020/5/25 21:32.
 */
public class SearchActivity extends BaseActivity<ActivitySearchBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }
}
