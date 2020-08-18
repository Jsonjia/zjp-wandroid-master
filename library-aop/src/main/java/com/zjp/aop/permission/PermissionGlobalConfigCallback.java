package com.zjp.aop.permission;

/**
 * Created by zjp on 2020/08/18 17:06
 */
public abstract class PermissionGlobalConfigCallback {

    abstract public void shouldShowRational(String permission, int ration);

    abstract public void onPermissonReject(String permission, int reject);
}
