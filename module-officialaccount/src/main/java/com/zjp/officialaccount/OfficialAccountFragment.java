package com.zjp.officialaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.common.router.RouterFragmentPath;

@Route(path = RouterFragmentPath.OfficialAccount.PAGER_OFFICIALACCOUNT)
public class OfficialAccountFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_official_account_fragment;
    }
}
