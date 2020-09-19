package com.zjp.officialaccount.fragment;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.ImmersionBar;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.common.bean.ArticleEntity;
import com.zjp.common.bean.ProjectTabBean;
import com.zjp.common.bean.page.PageInfo;
import com.zjp.common.ui.WebViewActivity;
import com.zjp.common.utils.CustomItemDecoration;
import com.zjp.officialaccount.R;
import com.zjp.officialaccount.adapter.CategoryAdapter;
import com.zjp.officialaccount.adapter.OfficialAccountListAdapter;
import com.zjp.officialaccount.databinding.FragmentOfficialAccountFragmentBinding;
import com.zjp.officialaccount.viewmodel.OfficialAccountViewModel;

import java.util.ArrayList;
import java.util.List;

@Route(path = RouterFragmentPath.OfficialAccount.PAGER_OFFICIALACCOUNT)
public class OfficialAccountFragment extends BaseFragment<FragmentOfficialAccountFragmentBinding, OfficialAccountViewModel> {

    private CategoryAdapter categoryAdapter;
    private OfficialAccountListAdapter officialAccountListAdapter;
    private PageInfo pageInfo;
    private int id = 0;
    private List<ArticleEntity.DatasBean> shareArticles = new ArrayList<>();

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
        return R.layout.fragment_official_account_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
        ViewGroup.LayoutParams layoutParams = mViewDataBinding.viewStatus.getLayoutParams();
        layoutParams.height = ImmersionBar.getStatusBarHeight(getActivity());
        mViewDataBinding.viewStatus.setLayoutParams(layoutParams);
        mViewDataBinding.tvTitle.setText("公众号");
        mViewDataBinding.setVm(mViewModel);
        initCategory();
        initArticleList();
        pageInfo = new PageInfo();
        mViewModel.getAuthorTabList();
//
    }

    @Override
    protected void initData() {
        super.initData();
//        mViewModel.mObjMutable.observe(this, objects -> {
//            if (objects == null || objects.size() == 0) {
//                return;
//            }
//            if (objects.get(0) instanceof ProjectTabBean) {
//
//
//            } else if (objects.get(1) instanceof ArticleEntity) {
//            }
//        });

        mViewModel.mProjectListMutable.observe(this, projectTabBeans -> {
            if (null != projectTabBeans && projectTabBeans.size() > 0) {
                projectTabBeans.get(0).setSelect(true);
                categoryAdapter.setList(projectTabBeans);
                loadOfficialAccountList(projectTabBeans.get(0).getId());
            }
        });

        mViewModel.mArticleMutable.observe(this, articleEntity -> {
            officialAccountListAdapter.getData().clear();
            if (null != articleEntity) {
                List<ArticleEntity.DatasBean> shareArticles = articleEntity.getDatas();
                pageInfo.nextPage();
                if (articleEntity.getCurPage() == 1) {
                    mViewDataBinding.recy.smoothScrollToPosition(0);
                    showContent();
                    if (shareArticles != null && shareArticles.size() > 0) {
                        showContent();
                        officialAccountListAdapter.setList(shareArticles);
                    } else {
                        showEmpty();
                    }
                } else {
                    officialAccountListAdapter.addData(shareArticles);
                }

                if (articleEntity.isOver()) {
                    mViewDataBinding.refresh.finishLoadMoreWithNoMoreData();
                }
                mViewDataBinding.refresh.finishRefresh(true);
                mViewDataBinding.refresh.finishLoadMore(true);
            }
        });

        categoryAdapter.setOnItemClickListener((adapter, view, position) -> {
            List<ProjectTabBean> adapterData = categoryAdapter.getData();
            for (ProjectTabBean ptb : adapterData) {
                ptb.setSelect(false);
            }
            ProjectTabBean projectTabBean = adapterData.get(position);
            projectTabBean.setSelect(true);
            categoryAdapter.notifyDataSetChanged();
            loadOfficialAccountList(projectTabBean.getId());
        });
    }

    private void loadOfficialAccountList(int id) {
        pageInfo.reset();
        mViewModel.getAuthorArticleList(id, pageInfo.page);
    }

    private void initCategory() {
        mViewDataBinding.recyCategory.setAdapter(categoryAdapter = new CategoryAdapter());
    }

    private void initArticleList() {
        mViewDataBinding.recy.addItemDecoration(new CustomItemDecoration(getActivity(),
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        mViewDataBinding.recy.setAdapter(officialAccountListAdapter = new OfficialAccountListAdapter());

        officialAccountListAdapter.setOnItemClickListener((adapter, view, position) -> {
            ArticleEntity.DatasBean datasBean = officialAccountListAdapter.getData().get(position);
            WebViewActivity.start(getActivity(), datasBean.getTitle(), datasBean.getLink());
        });
    }

}
