package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.zjp.base.activity.BaseActivity;
import com.zjp.common.ui.WebViewActivity;
import com.zjp.mine.R;
import com.zjp.mine.adapter.OpenSourceProjAdapter;
import com.zjp.mine.bean.OpenSourceProj;
import com.zjp.mine.databinding.ActivityOpensourceProjBinding;
import com.zjp.mine.util.DataUtils;
import com.zjp.mine.viewmodel.MineViewModel;

/**
 * Created by zjp on 2020/7/14 22:44.
 */
public class OpenSourceProjActivity extends BaseActivity<ActivityOpensourceProjBinding, MineViewModel> {

    private OpenSourceProjAdapter openSourceProjAdapter;

    public static void start(Context context) {
        context.startActivity(new Intent(context, OpenSourceProjActivity.class));
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
        return R.layout.activity_opensource_proj;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.titleview.setTitle("开源项目");

        mViewDataBinding.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.recy.setAdapter(openSourceProjAdapter = new OpenSourceProjAdapter());
        openSourceProjAdapter.setList(DataUtils.getData());

        openSourceProjAdapter.setOnItemClickListener((adapter, view, position) -> {
            OpenSourceProj openSourceProj = openSourceProjAdapter.getItem(position);
            if (openSourceProj != null) {
                WebViewActivity.start(OpenSourceProjActivity.this, openSourceProj.getAuthor(), openSourceProj.getLink());
            }
        });
    }
}
