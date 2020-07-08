package com.zjp.mine.activity;

import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivitySettingBinding;

/**
 * Created by zjp on 2020/7/7 21:46.
 */
public class SetingActivity extends BaseActivity<ActivitySettingBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected void initView() {
        super.initView();

        mViewDataBinding.title.setTitle("设置");
    }
}
