package com.zjp.common.page;

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

}
