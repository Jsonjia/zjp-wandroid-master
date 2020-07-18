package com.zjp.mine.fragment;

import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.aop.annotation.CheckLogin;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.mine.R;
import com.zjp.mine.activity.LeaderboardActivity;
import com.zjp.mine.activity.MyCollectArticleActivity;
import com.zjp.mine.activity.UserCenterActivity;
import com.zjp.mine.databinding.FragmentMineFragmentBinding;
import com.zjp.mine.viewmodel.MineViewModel;

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

        mViewDataBinding.setEventlistener(new EventListener());

        mViewModel.mIntegralLiveData.observe(this, integral -> {
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
    }

    private void loadUserInfo() {
        mViewModel.getIntegral();
    }


    public class EventListener {

        @CheckLogin()
        public void clickSet() {
            UserCenterActivity.start(getActivity());
        }

        @CheckLogin()
        public void clickGoLogin() {

        }

        @CheckLogin()
        public void clickIntergral() {
            LeaderboardActivity.start(getActivity());
        }

        @CheckLogin()
        public void clickMyIntergral() {

        }

        @CheckLogin()
        public void clickMyCollect() {
            MyCollectArticleActivity.start(getActivity());
        }

        @CheckLogin()
        public void clickMyShare() {

        }

        @CheckLogin()
        public void clickMyArticle() {

        }

        @CheckLogin()
        public void clickReadHistory() {

        }

        @CheckLogin()
        public void clickOpenSource() {

        }

        @CheckLogin()
        public void clickAboutAuthor() {

        }

    }
}
