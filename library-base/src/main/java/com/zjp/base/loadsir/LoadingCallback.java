package com.zjp.base.loadsir;

import android.content.Context;
import android.view.View;

import com.kingja.loadsir.callback.Callback;
import com.zjp.base.R;

/**
 * Created by zjp on 2020/5/15 13:37
 */
public class LoadingCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.base_layout_loading;
    }

    @Override
    public boolean getSuccessVisible() {
        return super.getSuccessVisible();
    }

    @Override
    protected boolean onReloadEvent(Context context, View view) {
        return true;
    }
}
