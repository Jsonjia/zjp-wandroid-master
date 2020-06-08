package com.zjp.square;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;

@Route(path = RouterFragmentPath.Square.PAGER_SQUARE)
public class SquareFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_square_fragment;
    }
}
