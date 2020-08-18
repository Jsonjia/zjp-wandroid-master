package com.zjp.mine.fragment;

import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.aop.checklogin.annotation.CheckLogin;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.mine.R;
import com.zjp.mine.activity.AboutMeActivity;
import com.zjp.mine.activity.LeaderboardActivity;
import com.zjp.mine.activity.MyCollectArticleActivity;
import com.zjp.mine.activity.MyIntergralActivity;
import com.zjp.mine.activity.MyShareActivity;
import com.zjp.mine.activity.OpenSourceProjActivity;
import com.zjp.mine.activity.SettingActivity;
import com.zjp.mine.bean.Integral;
import com.zjp.mine.databinding.FragmentMineFragmentBinding;
import com.zjp.mine.viewmodel.MineViewModel;

@Route(path = RouterFragmentPath.Mine.PAGER_MINE)
public class MineFragment extends BaseFragment<FragmentMineFragmentBinding, MineViewModel> {

    private Integral mIntegral;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(false)
                .init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
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
            this.mIntegral = integral;
            mViewDataBinding.tvId.setText("ID." + integral.getUserId());
            mViewDataBinding.tvLevel.setText("lv." + integral.getLevel());
            mViewDataBinding.tvIntergralVal.setText("当前积分：" + integral.getCoinCount());
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        UserInfo userInfo = MmkvHelper.getInstance().getUserInfo();

        if (userInfo == null) {
            mViewDataBinding.tvName.setText("未登录");
            mViewDataBinding.tvId.setVisibility(View.GONE);
            mViewDataBinding.tvLevel.setVisibility(View.GONE);
        } else {
            mViewDataBinding.tvName.setText(userInfo.getUsername());
            mViewDataBinding.tvId.setVisibility(View.VISIBLE);
            mViewDataBinding.tvLevel.setVisibility(View.VISIBLE);
            loadUserInfo();
        }

        mViewDataBinding.setEventlistener(new EventListener(mIntegral));
    }

    private void loadUserInfo() {
        mViewModel.getIntegral();
    }


    public class EventListener {

        private Integral integral;

        public EventListener(Integral integral) {
            this.integral = integral;
        }

        @CheckLogin()
        public void clickSet() {
            SettingActivity.start(getActivity());
        }

        @CheckLogin()
        public void clickGoLogin() {

        }

        @CheckLogin()
        public void clickIntergral() {
            LeaderboardActivity.start(getActivity(), integral);
        }

        @CheckLogin()
        public void clickMyIntergral() {
            MyIntergralActivity.start(getActivity());
        }

        @CheckLogin()
        public void clickMyCollect() {
            MyCollectArticleActivity.start(getActivity());
        }

        @CheckLogin()
        public void clickMyShare() {
            MyShareActivity.start(getActivity());
        }

        @CheckLogin()
        public void clickMyArticle() {

        }

        @CheckLogin()
        public void clickReadHistory() {

        }

        public void clickOpenSource() {
            OpenSourceProjActivity.start(getActivity());
        }

        @CheckLogin()
        public void clickAboutAuthor() {
            AboutMeActivity.start(getActivity());
        }

    }
}
