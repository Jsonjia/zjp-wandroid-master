package com.zjp.aop.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import com.zjp.base.application.BaseApplication;

/**
 * Created by zjp on 2020/08/18 17:15
 */
public class PermissionUtil {

    private static PermissionUtil permissionUtil;

    public static PermissionUtil getInstance() {
        if (permissionUtil == null) {
            permissionUtil = new PermissionUtil();
        }
        return permissionUtil;
    }

    private PermissionGlobalConfigCallback globalConfigCallback;

    private PermissionCallback callback;

    private String[] permissions;

    public void init(PermissionGlobalConfigCallback callback) {
        globalConfigCallback = callback;
    }

    public PermissionGlobalConfigCallback getGlobalConfigCallback() {
        return globalConfigCallback;
    }

    public PermissionUtil permisson(String[] permissons) {
        this.permissions = permissons;
        return this;
    }

    public PermissionUtil callback(PermissionCallback callback) {
        this.callback = callback;
        return this;
    }

    public void request() {
        if (permissions == null || permissions.length <= 0) {
            return;
        }
        PermissionActivity.request(BaseApplication.getInstance().getApplicationContext(), permissions, callback);
    }

    /**
     * Jump to Settings page of your application
     *
     * @param context
     */
    public static void startSettingsActivity(Context context) {
        Uri packageURI = Uri.parse("package:" + context.getPackageName());
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
