package com.zjp.base.interf;

/**
 * Created by zjp on 2020/4/30 16:12
 */
public interface IBaseView {

    /**
     * 显示内容
     */
    void showContent();

    /**
     * 显示加载提示
     */
    void showLoading();

    /**
     * 显示空页面
     */
    void showEmpty();

    /**
     * 刷新失败
     */
    void showFailure(String message);


}
