package com.zjp.main;


import android.content.Intent;
import android.util.SparseArray;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.zjp.base.activity.BaseActivity;
import com.zjp.base.router.RouterActivityPath;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.main.databinding.ActivityMainBinding;
import com.zjp.network.constant.C;

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> implements BottomNavigationView.OnNavigationItemSelectedListener {

    private int mCurrentPage = -1;

    public static final int FRAGMENT_HOME = 1;
    public static final int FRAGMENT_PROJECT = 2;
    public static final int FRAGMENT_SQUARE = 3;
    public static final int FRAGMENT_OFFICIAL_ACCOUNT = 4;
    public static final int FRAGMENT_MINE = 5;

    private FragmentManager mFragmentManager;
    private SparseArray<Fragment> mFragmentMap;

    private Fragment mHomeFragment, mProjectFragment, mSquareFragment, mOfficialAccountFragment, mMineFragment;
    private long mPreTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();

        mFragmentManager = getSupportFragmentManager();
        mFragmentMap = new SparseArray<>();
        pageTo(FRAGMENT_HOME);
        mViewDataBinding.bottomnavigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_home) {
            if (mCurrentPage != FRAGMENT_HOME) {
                pageTo(FRAGMENT_HOME);
            }
            return true;
        } else if (itemId == R.id.menu_project) {
            if (mCurrentPage != FRAGMENT_PROJECT) {
                pageTo(FRAGMENT_PROJECT);
            }
            return true;
        } else if (itemId == R.id.menu_square) {
            if (mCurrentPage != FRAGMENT_SQUARE) {
                pageTo(FRAGMENT_SQUARE);
            }
            return true;
        } else if (itemId == R.id.menu_official_account) {
            if (mCurrentPage != FRAGMENT_OFFICIAL_ACCOUNT) {
                pageTo(FRAGMENT_OFFICIAL_ACCOUNT);
            }
            return true;
        } else if (itemId == R.id.menu_mine) {
            if (mCurrentPage != FRAGMENT_MINE) {
                pageTo(FRAGMENT_MINE);
            }
            return true;
        }
        return false;
    }

    /**
     * 滚动到指定fragment
     */
    public void pageTo(int pageIndex) {
        mCurrentPage = pageIndex;
        if (mCurrentPage == FRAGMENT_HOME) {
            mViewDataBinding.bottomnavigation.setSelectedItemId(R.id.menu_home);
        } else if (mCurrentPage == FRAGMENT_PROJECT) {
            mViewDataBinding.bottomnavigation.setSelectedItemId(R.id.menu_project);
        } else if (mCurrentPage == FRAGMENT_SQUARE) {
            mViewDataBinding.bottomnavigation.setSelectedItemId(R.id.menu_square);
        } else if (mCurrentPage == FRAGMENT_OFFICIAL_ACCOUNT) {
            mViewDataBinding.bottomnavigation.setSelectedItemId(R.id.menu_official_account);
        } else if (mCurrentPage == FRAGMENT_MINE) {
            mViewDataBinding.bottomnavigation.setSelectedItemId(R.id.menu_mine);
        }
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragment(transaction);
        showFragment(pageIndex, transaction, mFragmentMap.get(pageIndex));
    }

    /**
     * 隐藏
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }

        if (mProjectFragment != null) {
            transaction.hide(mProjectFragment);
        }

        if (mSquareFragment != null) {
            transaction.hide(mSquareFragment);
        }

        if (mOfficialAccountFragment != null) {
            transaction.hide(mOfficialAccountFragment);
        }

        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }
    }

    /**
     * 显示
     */
    private void showFragment(int index, FragmentTransaction transaction, Fragment fragment) {
        if (fragment == null) {
            // 当传入的fragment没有被初始化
            if (index == FRAGMENT_HOME) {
                fragment = mHomeFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation();
            } else if (index == FRAGMENT_PROJECT) {
                fragment = mProjectFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Project.PAGER_PROJECT).navigation();
            } else if (index == FRAGMENT_SQUARE) {
                fragment = mSquareFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Square.PAGER_SQUARE).navigation();
            } else if (index == FRAGMENT_OFFICIAL_ACCOUNT) {
                fragment = mOfficialAccountFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.OfficialAccount.PAGER_OFFICIALACCOUNT).navigation();
            } else {
                fragment = mMineFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Mine.PAGER_MINE).navigation();
            }
            transaction.add(R.id.framelayout, fragment, fragment.getClass().getSimpleName());
            // 缓存住已经初始化的fragment，以便点击tab时传入到此方法中。
            mFragmentMap.put(index, fragment);
        } else {
            transaction.show(fragment);
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (System.currentTimeMillis() - mPreTime > C.BACK_DURATION) {
            Snackbar.make(mViewDataBinding.rootview, "再按一次退出 wanandroid", Snackbar.LENGTH_SHORT).show();
            mPreTime = System.currentTimeMillis();
            return;
        } else {
            startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME));
        }
        super.onBackPressed();
    }
}
