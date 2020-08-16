package com.zjp.mine.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.zjp.mine.R;

/**
 * Created by zjp on 2020/8/5 22:15.
 */
public class WarmTipBottomSheetDialogFragment extends BottomSheetDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_dialog_warm_tip, null, false);
        dialog.setContentView(view);
        ViewGroup parent = (ViewGroup) view.getParent();
        BottomSheetBehavior<ViewGroup> behavior = BottomSheetBehavior.from(parent);
        behavior.setPeekHeight(ScreenUtils.getScreenHeight() / 2);
        behavior.setHideable(false);

        ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
        layoutParams.height = ScreenUtils.getScreenHeight() / 6 * 5;
        parent.setLayoutParams(layoutParams);
        return dialog;
    }
}
