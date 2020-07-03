package com.zjp.square;

import android.os.Build;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.square.databinding.FragmentSquareFragmentBinding;

@Route(path = RouterFragmentPath.Square.PAGER_SQUARE)
public class SquareFragment extends BaseFragment<FragmentSquareFragmentBinding, BaseViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_square_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mViewDataBinding.fl.setElevation(10f);
        }

    }
}
