package com.zjp.mine.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.zjp.common.bean.UserInfo;
import com.zjp.mine.R;
import com.zjp.mine.databinding.AdapterItemMyIntergralBinding;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zjp on 2020/08/19 11:05
 */
public class MyIntergralAdapter extends BaseQuickAdapter<UserInfo, BaseDataBindingHolder<AdapterItemMyIntergralBinding>> {

    public MyIntergralAdapter() {
        super(R.layout.adapter_item_my_intergral);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<AdapterItemMyIntergralBinding> holder, UserInfo userInfo) {
        AdapterItemMyIntergralBinding binding = holder.getDataBinding();
        if (binding != null) {
            binding.setUserinfo(userInfo);
            binding.executePendingBindings();
        }
    }
}
