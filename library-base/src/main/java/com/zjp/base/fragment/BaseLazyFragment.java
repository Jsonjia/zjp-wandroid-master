package com.zjp.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.blankj.utilcode.util.ToastUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.zjp.base.interf.IBaseView;
import com.zjp.base.loadsir.EmptyCallback;
import com.zjp.base.loadsir.ErrorCallback;
import com.zjp.base.loadsir.LoadingCallback;
import com.zjp.base.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by zjp on 2020/7/1 9:54
 * 需要懒加载Fragment继承此类
 */
public abstract class BaseLazyFragment<V extends ViewDataBinding, VM extends BaseViewModel>
        extends Fragment implements IBaseView {

    protected ImmersionBar mImmersionBar;

    protected V mViewDataBinding;

    protected VM mViewModel;

    protected LoadService mLoadService;

    private boolean isShowedContent = false;

    private boolean isViewCreated; // 界面是否已创建完成
    private boolean isVisibleToUser; // 是否对用户可见
    public boolean isDataLoaded; // 数据是否已请求

    /**
     * 第一次可见时触发调用,此处实现具体的数据请求逻辑
     */
    protected abstract void lazyLoadData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initImmersionBar();
        mViewDataBinding =
                DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mViewDataBinding.setLifecycleOwner(this);

        mLoadService = LoadSir.getDefault().register(mViewDataBinding.getRoot(), new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {

            }
        });
        return mLoadService.getLoadLayout();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        getLifecycle().addObserver(mViewModel);
        initView();
        initData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        tryLoadData();
    }

    /**
     * 保证在initData后触发
     */
    @Override
    public void onResume() {
        super.onResume();
        isViewCreated = true;
        tryLoadData();
    }

    /**
     * ViewPager场景下，当前fragment可见时，如果其子fragment也可见，则让子fragment请求数据
     */
    private void dispatchParentVisibleState() {
        FragmentManager fragmentManager = getChildFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments.isEmpty()) {
            return;
        }
        for (Fragment child : fragments) {
            if (child instanceof BaseLazyFragment && ((BaseLazyFragment) child).isVisibleToUser) {
                ((BaseLazyFragment) child).tryLoadData();
            }
        }
    }

    public void tryLoadData() {
        if (isViewCreated && isVisibleToUser && !isDataLoaded) {
            lazyLoadData();
            isDataLoaded = true;
            //通知子Fragment请求数据
            dispatchParentVisibleState();
        }
    }

    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }

    @LayoutRes
    public abstract int getLayoutId();

    private void initViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            } else {
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        }
    }

    protected void initView() {

    }

    protected void initData() {

    }

    @Override
    public void showContent() {
        if (null != mLoadService) {
            isShowedContent = true;
            mLoadService.showSuccess();
        }
    }

    @Override
    public void showLoading() {
        if (null != mLoadService) {
            mLoadService.showCallback(LoadingCallback.class);
        }
    }

    @Override
    public void showEmpty() {
        if (null != mLoadService) {
            mLoadService.showCallback(EmptyCallback.class);
        }
    }

    @Override
    public void showFailure(@Nullable String message) {
        if (null != mLoadService) {
            if (!isShowedContent) {
                mLoadService.showCallback(ErrorCallback.class);
            } else {
                ToastUtils.showShort(message);
            }
        }
    }

    /**
     * 失败重试,重新加载事件
     */
    protected void onRetryBtnClick() {
    }
}
