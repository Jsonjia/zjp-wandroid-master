package com.zjp.mine.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.zjp.mine.R;
import com.zjp.mine.bean.OpenSourceProj;
import com.zjp.mine.databinding.AdapterOpenSourceProjBinding;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zjp on 2020/08/03 16:41
 */
public class OpenSourceProjAdapter extends BaseQuickAdapter<OpenSourceProj, BaseDataBindingHolder<AdapterOpenSourceProjBinding>> {

    public OpenSourceProjAdapter() {
        super(R.layout.adapter_open_source_proj);
    }


    @Override
    protected void convert(@NotNull BaseDataBindingHolder<AdapterOpenSourceProjBinding> bindingHolder, OpenSourceProj openSourceProj) {
        AdapterOpenSourceProjBinding dataBinding = bindingHolder.getDataBinding();
        if (dataBinding != null) {
            dataBinding.setOpensource(openSourceProj);
            dataBinding.executePendingBindings();
        }
    }
}
