package com.zjp.login.activity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.router.RouterActivityPath;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.login.R;
import com.zjp.login.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        super.initView();
        mViewDataBinding.particleview.startAnim();
        mViewDataBinding.particleview.setOnParticleAnimListener(() -> {
//            UserInfo userInfo = MmkvHelper.getInstance().getUserInfo();
//            if (userInfo == null) {
//                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//            } else {
            ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
//            }
            finish();
        });

    }
}
