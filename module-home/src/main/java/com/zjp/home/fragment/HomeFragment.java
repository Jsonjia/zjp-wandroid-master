package com.zjp.home.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import com.zjp.base.event.IEventBus;
import com.zjp.base.event.SettingEvent;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.common.adapter.ArticleListAdapter;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.common.storage.MmkvHelper;
import com.zjp.common.ui.WebViewActivity;
import com.zjp.common.utils.CustomItemDecoration;
import com.zjp.home.R;
import com.zjp.home.activity.SearchActivity;
import com.zjp.home.adapter.HomeHeadBannerAdapter;
import com.zjp.home.databinding.HomeFragmentHomeBinding;
import com.zjp.home.viewmodel.HomeViewModel;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

@Route(path = RouterFragmentPath.Home.PAGER_HOME)
public class HomeFragment extends BaseFragment<HomeFragmentHomeBinding, HomeViewModel> implements IEventBus {

    private ArticleListAdapter articleListAdapter;
    private PageInfo pageInfo;
    private boolean isLoading = true;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
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
        return R.layout.home_fragment_home;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initView() {
        super.initView();


        pageInfo = new PageInfo();
        setLoadSir(mViewDataBinding.rootview);
        mViewDataBinding.recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewDataBinding.recy.addItemDecoration(new CustomItemDecoration(getActivity(),
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        articleListAdapter = new ArticleListAdapter(null);
        mViewDataBinding.recy.setAdapter(articleListAdapter);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            mViewDataBinding.cl.setElevation(10f);
//            mViewDataBinding.llRadius.setElevation(20f);
//            mViewDataBinding.recy.setNestedScrollingEnabled(false);
//        }

        //解决swiperefresh与scrollview滑动冲突问题
        mViewDataBinding.appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            /**
             *   verticalOffset == 0 时候也就是Appbarlayout完全展开的时候，事件交给swiperefresh
             */
//            mViewDataBinding.swipe.setEnabled(verticalOffset == 0);
        });

        mViewDataBinding.nestscrollview.getViewTreeObserver().addOnScrollChangedListener(() -> {
            /**
             * 原理如上
             */
//            mViewDataBinding.swipe.setEnabled(mViewDataBinding.nestscrollview.getScrollY() == 0);
        });

        mViewDataBinding.nestscrollview.setOnScrollChangeListener((View.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            float alpha = 0f;
            if (scrollY > 0) {
                mViewDataBinding.ivSearch.setEnabled(true);
                alpha = (float) scrollY / (float) 300;
            } else {
                mViewDataBinding.ivSearch.setEnabled(false);
            }
            mViewDataBinding.cl.setAlpha(alpha);
        });

        mViewDataBinding.refresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageInfo.reset();
                loadData();
            }
        });

        loadData();

        mViewDataBinding.ivSearch.setOnClickListener(v -> {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mViewDataBinding.ivSearch, "search");
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            ActivityCompat.startActivity(getActivity(), intent, optionsCompat.toBundle());
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mBannerListMutable.observe(this, bannerEntities -> {
            if (mViewDataBinding.refresh.getState().isOpening) {
                mViewDataBinding.refresh.finishRefresh();
                mViewDataBinding.refresh.finishLoadMore();
            }

            if (bannerEntities != null && bannerEntities.size() > 0) {
                mViewDataBinding.banner.setAdapter(new HomeHeadBannerAdapter(bannerEntities))
                        .setIndicator(new CircleIndicator(getActivity()))
                        .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                        .setIndicatorMargins(new IndicatorConfig.Margins(0, 0,
                                BannerConfig.INDICATOR_SELECTED_WIDTH, (int) BannerUtils.dp2px(40)))
                        .setOnBannerListener((data, position) -> {
                            Intent intent = new Intent(getActivity(), WebViewActivity.class);
                            intent.putExtra("link", bannerEntities.get(position).getUrl());
                            startActivity(intent);
                        });
            }
        });

        mViewModel.mArticleListMutable.observe(this, datasBeans -> {
            if (mViewDataBinding.refresh.getState().isOpening) {
                mViewDataBinding.refresh.finishRefresh();
            }

            if (isLoading)
                showContent();
            articleListAdapter.setList(datasBeans);
            pageInfo.nextPage();
            isLoading = false;
        });

        //加载更多
        mViewModel.mArticleMutable.observe(this, articleEntity -> {
            if (mViewDataBinding.refresh.getState().isOpening)
                mViewDataBinding.refresh.finishLoadMore();
            if (null != articleEntity) {
                List<ArticleEntity.DatasBean> entityDatas = articleEntity.getDatas();
                if (null != entityDatas && entityDatas.size() > 0) {
                    articleListAdapter.addData(entityDatas);
                    pageInfo.nextPage();
                }
            }
        });

        articleListAdapter.setOnItemClickListener((adapter, view, position) -> {
            ArticleEntity.DatasBean datasBean = articleListAdapter.getData().get(position);
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra("link", datasBean.getLink());
            startActivity(intent);
        });
    }

    private void loadData() {
        if (pageInfo.isFirstPage()) {
            mViewModel.getBanner();

            if (MmkvHelper.getInstance().getHideTopArticle()) { //隐藏置顶文章

            } else {
                mViewModel.getArticleMultiList(pageInfo.page);
            }
        } else {
            mViewModel.getArticleList(pageInfo.page);
        }
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Subscribe
    public void onEvent(SettingEvent settingEvent) {
        if (settingEvent != null) {
            if (settingEvent.isHideTopArticle()) {//隐藏
                removeTopItems();
            } else {

            }

        }
    }

    private void removeTopItems() {

    }
}
