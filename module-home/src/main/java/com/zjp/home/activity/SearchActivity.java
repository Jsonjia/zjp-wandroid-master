package com.zjp.home.activity;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.KeyboardUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.home.R;
import com.zjp.home.adapter.HomeSearchAdapter;
import com.zjp.home.databinding.ActivitySearchBinding;

/**
 * Created by zjp on 2020/5/25 21:32.
 */
public class SearchActivity extends BaseActivity<ActivitySearchBinding, BaseViewModel> {

    private HomeSearchAdapter homeSearchAdapter;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        super.initView();

        ViewGroup.LayoutParams layoutParams = mViewDataBinding.viewStatus.getLayoutParams();
        layoutParams.height = ImmersionBar.getStatusBarHeight(this);
        mViewDataBinding.viewStatus.setLayoutParams(layoutParams);

        mViewDataBinding.recyclerHistory.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.recyclerHistory.setAdapter(homeSearchAdapter = new HomeSearchAdapter());


        mViewDataBinding.ivBack.setOnClickListener(v -> {
            finishAfterTransition();
            KeyboardUtils.hideSoftInput(SearchActivity.this);
        });
    }

    @Override
    protected void initData() {
        super.initData();

    }
}
