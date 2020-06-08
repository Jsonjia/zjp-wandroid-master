package com.zjp.mine;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;

@Route(path = RouterFragmentPath.Mine.PAGER_MINE)
public class MineFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine_fragment;
    }
}
