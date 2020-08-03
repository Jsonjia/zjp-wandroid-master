package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import com.zjp.base.activity.BaseActivity;
import com.zjp.mine.R;
import com.zjp.mine.databinding.ActivityMyIntergralBinding;
import com.zjp.mine.viewmodel.MineViewModel;

/**
 * Created by zjp on 2020/07/15 17:07
 */
public class MyIntergralActivity extends BaseActivity<ActivityMyIntergralBinding, MineViewModel> {

    public static void start(Context context) {
        context.startActivity(new Intent(context, MyIntergralActivity.class));
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_intergral;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("我的收藏");
    }
}
