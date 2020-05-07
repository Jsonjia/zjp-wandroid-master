package com.zjp.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.common.router.RouterFragmentPath;

@Route(path = RouterFragmentPath.Project.PAGER_PROJECT)
public class ProjectFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project_fragment;
    }
}
