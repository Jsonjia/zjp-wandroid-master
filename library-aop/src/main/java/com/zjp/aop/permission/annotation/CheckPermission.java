package com.zjp.aop.permission.annotation;

/**
 * Created by zjp on 2020/08/18 17:12
 */
public @interface CheckPermission {

    //申请的权限可能有多个，所以用数组
    String[] permissions();

    int[] rationales() default {};

    //拒绝
    int[] rejects() default {};
}
