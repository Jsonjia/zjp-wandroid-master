package com.zjp.aop.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.zjp.aop.annotation.CheckLogin;
import com.zjp.base.router.RouterActivityPath;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.storage.MmkvHelper;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by zjp on 2020/07/07 17:17
 */
@Aspect
public class CheckLoginAspect {

    @Pointcut("execution(@com.zjp.aop.annotation.CheckLogin * *(..))")
    public void pointcutCheckLogin() {

    }

    @Around("pointcutCheckLogin()")
    public void aroundCheckPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        ToastUtils.showShort("ddddd");
        Log.d("zjp1", "测迟到吃到迟到");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckLogin checkLogin = signature.getMethod().getAnnotation(CheckLogin.class);
        Context context = (Context) joinPoint.getThis();
        UserInfo userInfo = MmkvHelper.getInstance().getUserInfo();
//        if (userInfo == null) {
//            ARouter.getInstance().build(RouterActivityPath.Login.LOGIN).navigation();
//            return null;
//        } else {
//            return joinPoint.proceed();
//        }
    }
}
