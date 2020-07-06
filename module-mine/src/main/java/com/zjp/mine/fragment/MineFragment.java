package com.zjp.mine.fragment;

import android.view.Gravity;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.mine.R;
import com.zjp.mine.databinding.FragmentMineFragmentBinding;
import com.zjp.mine.widget.WaveView;

@Route(path = RouterFragmentPath.Mine.PAGER_MINE)
public class MineFragment extends BaseFragment<FragmentMineFragmentBinding, BaseViewModel> {

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine_fragment;
    }

    @Override
    protected void initView() {
        super.initView();
    }
}
