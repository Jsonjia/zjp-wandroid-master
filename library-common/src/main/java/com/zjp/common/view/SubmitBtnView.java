package com.zjp.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatButton;

import com.zjp.common.R;

/**
 * Created by zjp on 2020/5/19 21:13.
 */
public class SubmitBtnView extends AppCompatButton implements TextWatcher {

    private int[] mBindIds;
    private boolean mHasInit = false;
    private EditText[] mEditTexts;

    public SubmitBtnView(Context context) {
        this(context, null);
    }

    public SubmitBtnView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SubmitBtnView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SubmitBtnView);
        mBindIds = new int[]{
                typedArray.getResourceId(R.styleable.SubmitBtnView_sv_bindEditText1, NO_ID),
                typedArray.getResourceId(R.styleable.SubmitBtnView_sv_bindEditText2, NO_ID),
                typedArray.getResourceId(R.styleable.SubmitBtnView_sv_bindEditText3, NO_ID)
        };
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mHasInit) {
            return;
        }
        mHasInit = true;
        mEditTexts = new EditText[mBindIds.length];
        for (int i = 0; i < mBindIds.length; i++) {
            View bindView = getRootView().findViewById(mBindIds[i]);
            EditText editText = null;
            if (bindView instanceof EditText) {
                editText = (EditText) bindView;
            } else if (bindView instanceof EditTextWrapper) {
                EditTextWrapper editTextWrapper = (EditTextWrapper) bindView;
                editText = editTextWrapper.getEditText();
            }
            mEditTexts[i] = editText;
            if (mEditTexts[i] != null) {
                mEditTexts[i].addTextChangedListener(this);
            }
        }
        for (EditText et : mEditTexts) {
            if (et != null) {
                et.setText(et.getText().toString());
                et.setSelection(et.getText().toString().length());
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        boolean hasEmpty = false;
        for (EditText et : mEditTexts) {
            if (et != null && TextUtils.isEmpty(et.getText().toString())) {
                hasEmpty = true;
                break;
            }
        }
        if (hasEmpty) {
            setAlpha(0.7F);
            setEnabled(false);
        } else {
            setAlpha(1.0F);
            setEnabled(true);
        }
    }

    public interface EditTextWrapper {
        EditText getEditText();
    }
}
