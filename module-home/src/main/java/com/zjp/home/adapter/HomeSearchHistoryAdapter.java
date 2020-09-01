package com.zjp.home.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.zjp.home.R;
import com.zjp.home.databinding.AdapterSearchHistoryItemBinding;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zjp on 2020/5/29 17:20
 */
public class HomeSearchHistoryAdapter extends BaseQuickAdapter<String, BaseDataBindingHolder<AdapterSearchHistoryItemBinding>>  {

    public HomeSearchHistoryAdapter() {
        super(R.layout.adapter_search_history_item);
        addChildClickViewIds(R.id.clear_keywords_ib);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<AdapterSearchHistoryItemBinding> bindingHolder, String string) {
        AdapterSearchHistoryItemBinding dataBinding = bindingHolder.getDataBinding();
        if (dataBinding != null) {
            dataBinding.setKeyword(string);
            dataBinding.executePendingBindings();
        }

    }
}
