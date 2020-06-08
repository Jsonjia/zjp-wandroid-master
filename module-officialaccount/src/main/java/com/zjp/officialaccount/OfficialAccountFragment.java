package com.zjp.officialaccount;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;

@Route(path = RouterFragmentPath.OfficialAccount.PAGER_OFFICIALACCOUNT)
public class OfficialAccountFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_official_account_fragment;
    }
}
