package com.zjp.aop.permission.aspect;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.zjp.aop.permission.PermissionCallback;
import com.zjp.aop.permission.PermissionUtil;
import com.zjp.aop.permission.annotation.CheckPermission;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjp on 2020/08/18 17:12
 */
public class CheckPermissionAspect {

    @Pointcut("execution(@com.zjp.aop.permission.annotation.CheckPermission * *(..))")
    public void requestPermission(CheckPermission checkPermission) {

    }

    @Around("requestPermission(checkPermission)")
    public void aroundRequestPermission(final ProceedingJoinPoint joinPoint, CheckPermission checkPermission) {
        try {
            Context context = null;
            final Object object = joinPoint.getThis();
            if (object instanceof Context) {
                context = (Context) object;
            } else if (object instanceof Fragment) {
                context = ((Fragment) object).getActivity();
            } else if (object instanceof AppCompatActivity) {
                context = (AppCompatActivity) object;
            }

            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();

            // 获取注解参数，这里我们有3个参数需要获取
            final String[] permissions = checkPermission.permissions();
            final int[] rationales = checkPermission.rationales();
            final int[] rejects = checkPermission.rejects();
            final List<String> permissionList = Arrays.asList(permissions);

            PermissionUtil.getInstance()
                    .permisson(permissions)
                    .callback(new PermissionCallback() {
                        @Override
                        public void onPermissionGranted() {
                            try {
                                joinPoint.proceed();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }

                        @Override
                        public void shouldShowRational(String permisson) {
                            int index = permissionList.indexOf(permisson);
                            int rationale = -1;
                            if (rationales.length > index) {
                                rationale = rationales[index];
                            }
                            PermissionUtil.getInstance().getGlobalConfigCallback().shouldShowRational(permisson, rationale);
                        }

                        @Override
                        public void onPermissonReject(String permisson) {
                            int index = permissionList.indexOf(permisson);
                            int reject = -1;
                            if (rejects.length > index) {
                                reject = rejects[index];
                            }
                            PermissionUtil.getInstance().getGlobalConfigCallback().onPermissonReject(permisson, reject);
                        }
                    }).request();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
