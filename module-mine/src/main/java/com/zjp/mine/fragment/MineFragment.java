package com.zjp.mine.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.zjp.aop.annotation.CheckLogin;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.mine.R;
import com.zjp.mine.bean.Integral;
import com.zjp.mine.databinding.FragmentMineFragmentBinding;
import com.zjp.mine.viewmodel.MineViewModel;
import com.zjp.mine.widget.WaveView;

@Route(path = RouterFragmentPath.Mine.PAGER_MINE)
public class MineFragment extends BaseFragment<FragmentMineFragmentBinding, MineViewModel> {

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(false)
                .init();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            initImmersionBar();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine_fragment;
    }

    @Override
    protected void initView() {
        super.initView();

        UserInfo userInfo = MmkvHelper.getInstance().getUserInfo();

        if (userInfo == null) {
            mViewDataBinding.tvName.setText("未登录");
            mViewDataBinding.tvLevel.setVisibility(View.GONE);
        } else {
            mViewDataBinding.tvLevel.setVisibility(View.VISIBLE);
            loadUserInfo();
        }

        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) mViewDataBinding.cl.getLayoutParams();
        mViewDataBinding.waveview.setOnWaveAnimationListener(y -> {
            lp.setMargins(0, 0, 0, (int) y + 90);
            mViewDataBinding.cl.setLayoutParams(lp);
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mIntegralLiveData.observe(this, integral -> {
            mViewDataBinding.tvName.setText(integral.getUsername());
            mViewDataBinding.tvLevel.setText(integral.getLevel());

        });

        mViewDataBinding.tvName.setOnClickListener(view -> skip());
    }

    private void loadUserInfo() {
        mViewModel.getIntegral();
    }

    @CheckLogin()
    public void skip() {
//        ToastUtils.showShort("我登录成功了");
    }
}
