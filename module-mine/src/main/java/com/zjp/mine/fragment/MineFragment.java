package com.zjp.mine.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

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

//        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams();
//        lp.gravity = Gravity.BOTTOM ;
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) mViewDataBinding.cl.getLayoutParams();
//        lp.gravity = Gravity.BOTTOM ;
        mViewDataBinding.waveview.setOnWaveAnimationListener(new WaveView.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
                Log.d("zjp","dsdsd"+(int) y + 2);
                lp.setMargins(0, 0, 0, (int) y +90);
                mViewDataBinding.cl.setLayoutParams(lp);
            }
        });
    }
}
