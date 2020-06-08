package com.zjp.base.aop;

import android.content.Context;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by zjp on 2020/6/8 16:24
 */
@Aspect
public class LoginAspect {

    private final static String TAG = "loginAspect";

    @Pointcut("executation(@com.zjp.base.aop * *(..)")
    public void LoginFilter() {
    }

    @Around("LoginFilter()")
    public void aroundLoginPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取用户实现的ILogin类，如果没有调用init()设置初始化就抛出异常。
        ILoginFilter iLoginFilter = LoginAssistant.getInstance().getILoginFilter();
        if (iLoginFilter == null) {
            throw new RuntimeException("LoginManger没有初始化");
        }
        //先得到方法的签名methodSignature，然后得到@LoginFilter注解，如果注解为空，就不再往下走。
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MemberSignature)) {
            throw new RuntimeException("该注解只能用于方法上");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        CheckLogin checkLogin = methodSignature.getMethod().getAnnotation(CheckLogin.class);
        if (checkLogin == null) {
            return;
        }
        Context mContext = LoginAssistant.getInstance().getApplicationContext();
        //调用iLogin的isLogin()方法判断是否登录，这个isLogin是留给使用者自己实现的，如果登录，就会继续执行方法体调用方法直到完成，如果没有登录，执行下一个
        if (iLoginFilter.isLogin(mContext)) {
            joinPoint.proceed();
        } else {
            iLoginFilter.login(mContext, checkLogin.loginDefine());
        }
    }
}
