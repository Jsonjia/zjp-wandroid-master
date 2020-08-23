package com.zjp.login.activity;

import android.content.Intent;

import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.router.RouterActivityPath;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.bean.ProjectTabBean;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.login.R;
import com.zjp.login.databinding.ActivitySplashBinding;
import com.zjp.login.viewmodel.LoginViewModel;
import com.zjp.network.constant.C;

import java.util.List;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, LoginViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        super.initView();

        mViewModel.getProjectTab();
        mViewDataBinding.particleview.startAnim();
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.mProjectListMutable.observe(this, projectTabBeans -> {
            if (null != projectTabBeans && projectTabBeans.size() > 0) {

                mViewDataBinding.particleview.setOnParticleAnimListener(() -> {
//                        UserInfo userInfo = MmkvHelper.getInstance().getUserInfo();
//                        if (userInfo == null) {
//                            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                        } else {
                    MmkvHelper.getInstance().saveList(C.PROJECT_TAB, projectTabBeans);
                    ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
//                        }
                    finish();
                });
            }
        });
    }
}
