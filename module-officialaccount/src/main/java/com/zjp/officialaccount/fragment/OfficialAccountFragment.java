package com.zjp.officialaccount.fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.officialaccount.R;
import com.zjp.officialaccount.adapter.CategoryAdapter;
import com.zjp.officialaccount.databinding.FragmentOfficialAccountFragmentBinding;
import com.zjp.officialaccount.viewmodel.OfficialAccountViewModel;

@Route(path = RouterFragmentPath.OfficialAccount.PAGER_OFFICIALACCOUNT)
public class OfficialAccountFragment extends BaseFragment<FragmentOfficialAccountFragmentBinding, OfficialAccountViewModel> {

    private CategoryAdapter categoryAdapter;

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
        mViewDataBinding.setVm(mViewModel);
        initCategory();

        mViewModel.getAuthorTabList();
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.mProjectListMutable.observe(this, projectTabBeans -> {
            if (null != projectTabBeans && projectTabBeans.size() > 0) {
                categoryAdapter.setList(projectTabBeans);
            }
        });
    }

    private void initCategory() {
        mViewDataBinding.recyCategory.setAdapter(categoryAdapter = new CategoryAdapter());
    }

}
