package com.zjp.officialaccount;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.officialaccount.databinding.FragmentOfficialAccountFragmentBinding;

@Route(path = RouterFragmentPath.OfficialAccount.PAGER_OFFICIALACCOUNT)
public class OfficialAccountFragment extends BaseFragment<FragmentOfficialAccountFragmentBinding, BaseViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_official_account_fragment;
    }

    @Override
    protected void initView() {
        super.initView();

    }


}
