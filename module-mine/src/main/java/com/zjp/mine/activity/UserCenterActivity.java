package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.immersionbar.ImmersionBar;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.mine.R;
import com.zjp.mine.adapter.SimpleAdapter;
import com.zjp.mine.databinding.ActivityUsercenterBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjp on 2020/7/17 21:54.
 */
public class UserCenterActivity extends BaseActivity<ActivityUsercenterBinding, BaseViewModel> {

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarColorInt(getResources().getColor(R.color.colorPrimary))
                .statusBarDarkFont(false)
                .init();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, UserCenterActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_usercenter;
    }

    @Override
    protected void initView() {
        super.initView();

        ViewGroup.LayoutParams layoutParams = mViewDataBinding.co.getLayoutParams();
//        layoutParams.height = ImmersionBar.getStatusBarHeight(this);
//        mViewDataBinding.appbar.setLayoutParams(layoutParams);
        mViewDataBinding.co.setPadding(0, ImmersionBar.getStatusBarHeight(this), 0, 0);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("items+" + i);
        }

        RecyclerView recyclerView = findViewById(R.id.recyleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SimpleAdapter(list));
    }
}
