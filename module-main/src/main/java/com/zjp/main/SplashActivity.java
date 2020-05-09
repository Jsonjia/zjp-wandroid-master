package com.zjp.main;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.router.RouterActivityPath;
import com.zjp.main.databinding.ActivitySplashBinding;

/**
 * Created by zjp on 2020/5/9 16:41
 */
public class SplashActivity extends BaseActivity<ActivitySplashBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        super.initView();
        ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
    }
}
