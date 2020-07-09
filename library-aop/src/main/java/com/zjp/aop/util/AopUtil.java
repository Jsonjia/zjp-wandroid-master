package com.zjp.aop.util;

/**
 * Created by zjp on 2020/07/09 16:32
 */
public class AopUtil {

    private static AopUtil aopUtil;

    public static AopUtil getInstance() {
        if (aopUtil == null) {
            aopUtil = new AopUtil();
        }
        return aopUtil;
    }


}
