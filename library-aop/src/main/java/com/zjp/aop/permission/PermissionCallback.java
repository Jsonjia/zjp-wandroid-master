package com.zjp.aop.permission;

/**
 * Created by zjp on 2020/08/18 17:16
 */
public interface PermissionCallback {

    void onPermissionGranted();

    void shouldShowRational(String permisson);

    void onPermissonReject(String permisson);
}
