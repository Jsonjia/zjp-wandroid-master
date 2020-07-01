package com.zjp.common.bean.page;

/**
 * Created by zjp on 2020/5/24 15:22.
 */
public class PageInfo {

    public int page = 1;

    public void nextPage() {
        page++;
    }

    public void reset() {
        page = 1;
    }

    public boolean isFirstPage() {
        return page == 1;
    }

    /**************************************  我是分割线   ***************************************/
    public int mPage = 0;

    public void nextZeroPage() {
        mPage++;
    }

    public void resetZero() {
        mPage = 0;
    }

    public boolean isZeroPage() {
        return mPage == 0;
    }

}
