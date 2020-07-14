package com.zjp.mine.activity;

import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivityOpensourceProjBinding;

/**
 * Created by zjp on 2020/7/14 22:44.
 */
public class OpenSourceProjActivity extends BaseActivity<ActivityOpensourceProjBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_opensource_proj;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("开源项目");
    }
}
