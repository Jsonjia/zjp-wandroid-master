package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.gyf.immersionbar.ImmersionBar;
import com.zjp.base.activity.BaseActivity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.mine.R;
import com.zjp.mine.adapter.SimpleAdapter;
import com.zjp.mine.bean.Integral;
import com.zjp.mine.databinding.ActivityUsercenter1Binding;
import com.zjp.mine.viewmodel.MineViewModel;
import com.zjp.network.constant.C;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjp on 2020/7/17 21:54.
 */
public class UserCenterActivity extends BaseActivity<ActivityUsercenter1Binding, MineViewModel> {

    private int userId;
    private PageInfo pageInfo;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarColorInt(getResources().getColor(R.color.colorPrimary))
                .statusBarDarkFont(false)
                .init();
    }

    public static void start(Context context, int userId) {
        Intent intent = new Intent(context, UserCenterActivity.class);
        intent.putExtra(C.USERID, userId);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_usercenter1;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = getIntent();
        if (null != intent) {
            userId = intent.getIntExtra(C.USERID, 0);
        }

        mViewDataBinding.co.setPadding(0, ImmersionBar.getStatusBarHeight(this), 0, 0);
        pageInfo = new PageInfo();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("items+" + i);
        }

        mViewDataBinding.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.recy.setAdapter(new SimpleAdapter(list));

        mViewModel.getUserCenter(userId, pageInfo.page);
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.userCenterLiveData.observe(this, userCenter -> {
            if (userCenter != null) {
                Integral coinInfo = userCenter.getCoinInfo();
                mViewDataBinding.setUserinfo(coinInfo);


            }
        });
    }
}
