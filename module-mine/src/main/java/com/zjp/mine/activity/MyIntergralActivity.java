package com.zjp.mine.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.zjp.base.activity.BaseActivity;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.common.ui.WebViewActivity;
import com.zjp.mine.R;
import com.zjp.mine.adapter.MyIntergralAdapter;
import com.zjp.mine.databinding.ActivityMyIntergralBinding;
import com.zjp.mine.viewmodel.MineViewModel;
import com.zjp.network.constant.C;

import java.util.List;

/**
 * Created by zjp on 2020/07/15 17:07
 */
public class MyIntergralActivity extends BaseActivity<ActivityMyIntergralBinding, MineViewModel>
        implements OnLoadMoreListener {

    private PageInfo pageInfo;
    private MyIntergralAdapter myIntergralAdapter;

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
        mViewDataBinding.titleview.setTitle("我的积分");
        mViewDataBinding.titleview.getIvRight().setImageResource(R.mipmap.ic_guize);
        mViewDataBinding.titleview.setIvRightVisible(View.VISIBLE);
        pageInfo = new PageInfo();
        mViewDataBinding.rvIntergralList.setAdapter(myIntergralAdapter = new MyIntergralAdapter());
        setLoadSir(mViewDataBinding.rootview);
        loadData();
    }

    @Override
    protected void initData() {
        super.initData();

        mViewModel.mLeaderBoardMuTable.observe(this, leaderboard -> {
            if (null != leaderboard) {
                List<UserInfo> userInfos = leaderboard.getDatas();
                pageInfo.nextPage();
                if (leaderboard.getCurPage() == 1) {
                    startAnim();//设置"我的积分"动画

                    if (userInfos != null && userInfos.size() > 0) {
                        showContent();
                        myIntergralAdapter.setList(userInfos);
                    } else {
                        showEmpty();
                    }
                } else {
                    myIntergralAdapter.addData(userInfos);
                }

                if (leaderboard.isOver()) {
                    mViewDataBinding.smartRefresh.finishLoadMoreWithNoMoreData();
                }
                mViewDataBinding.smartRefresh.finishLoadMore(true);
            }
        });

        mViewDataBinding.smartRefresh.setOnLoadMoreListener(this);
        mViewDataBinding.titleview.getIvRight().setOnClickListener(view -> {
            WebViewActivity.start(this, "积分规则", C.INTERGRAL_URL);
        });
    }

    private void loadData() {
        mViewModel.getIntegralRecord(pageInfo.page);
    }

    private void startAnim() {
        String coinCount = MmkvHelper.getInstance().getUserInfo().getCoinCount();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, Integer.parseInt(coinCount));
        //播放时长
        valueAnimator.setDuration(C.DURATION);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(valueAnimator1 -> {
            //获取改变后的值
            int currentValue = (int) valueAnimator1.getAnimatedValue();
            mViewDataBinding.tvIntegralAnim.setText(currentValue + "");
        });
        valueAnimator.start();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        loadData();
    }
}
