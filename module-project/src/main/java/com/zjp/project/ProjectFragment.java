package com.zjp.project;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.zjp.base.fragment.BaseFragment;
import com.zjp.base.viewmodel.BaseViewModel;
import com.zjp.base.router.RouterFragmentPath;
import com.zjp.project.databinding.FragmentProjectFragmentBinding;

@Route(path = RouterFragmentPath.Project.PAGER_PROJECT)
public class ProjectFragment extends BaseFragment<FragmentProjectFragmentBinding, BaseViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project_fragment;
    }
}
