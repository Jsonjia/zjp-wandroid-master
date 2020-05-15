package com.zjp.base.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.zjp.base.R;

/**
 * Created by zjp on 2020/5/15 13:32
 */
public class EmptyCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.base_layout_empty;
    }
}
