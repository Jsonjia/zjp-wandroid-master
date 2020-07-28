package com.zjp.mine.activity;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gyf.immersionbar.ImmersionBar;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zjp.base.activity.BaseActivity;
import com.zjp.common.adapter.ArticleListAdapter;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.common.utils.CustomItemDecoration;
import com.zjp.mine.R;
import com.zjp.mine.bean.Integral;
import com.zjp.mine.databinding.ActivityUsercenter1Binding;
import com.zjp.mine.viewmodel.MineViewModel;
import com.zjp.network.constant.C;

import java.util.List;

/**
 * Created by zjp on 2020/7/17 21:54.
 */
public class UserCenterActivity extends BaseActivity<ActivityUsercenter1Binding, MineViewModel> implements OnRefreshLoadMoreListener {

    private int userId;
    private PageInfo pageInfo;
    private ArticleListAdapter articleListAdapter;

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
        pageInfo = new PageInfo();
        mViewDataBinding.recy.setLayoutManager(new LinearLayoutManager(this));
        mViewDataBinding.recy.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        mViewDataBinding.recy.setAdapter(articleListAdapter = new ArticleListAdapter(null));
        mViewDataBinding.co.setPadding(0, ImmersionBar.getStatusBarHeight(this), 0, 0);
        setLoadSir(mViewDataBinding.co);
        loadData();
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.userCenterLiveData.observe(this, userCenter -> {
            if (userCenter != null) {
                ArticleEntity shareArticles = userCenter.getShareArticles();
                List<ArticleEntity.DatasBean> datas = shareArticles.getDatas();
                pageInfo.nextPage();
                if (shareArticles.getCurPage() == 1) {
                    Integral coinInfo = userCenter.getCoinInfo();
                    mViewDataBinding.setUserInfo(coinInfo);
                    if (datas != null && datas.size() > 0) {
                        showContent();
                        articleListAdapter.setList(datas);
                    } else {
                        showEmpty();
                    }
                } else {
                    articleListAdapter.addData(datas);
                }

                if (shareArticles.isOver()) {
                    mViewDataBinding.smart.finishLoadMoreWithNoMoreData();
                }
                mViewDataBinding.smart.finishRefresh(true);
                mViewDataBinding.smart.finishLoadMore(true);
            }
        });

        mViewDataBinding.smart.setOnRefreshLoadMoreListener(this);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        loadData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pageInfo.reset();
        loadData();
    }

    private void loadData() {
        mViewModel.getUserCenter(userId, pageInfo.page);
    }
}
