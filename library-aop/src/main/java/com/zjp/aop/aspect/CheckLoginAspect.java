package com.zjp.aop.aspect;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zjp.aop.annotation.CheckLogin;
import com.zjp.base.router.RouterActivityPath;
import com.zjp.common.bean.UserInfo;
import com.zjp.common.storage.MmkvHelper;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zjp on 2020/07/07 17:17
 */
@Aspect
public class CheckLoginAspect {

    @Pointcut("execution(" +//执行语句
            "@com.zjp.aop.annotation.CheckLogin" +//注解筛选
            " * " + //类路径,*为任意路径
            "*" +   //方法名,*为任意方法名
            "(..)" +//方法参数,'..'为任意个任意类型参数
            ")" +
            " && " +//并集
            "@annotation(checkLogin)"//注解筛选,这里主要用于下面方法的'NeedLogin'参数获取
    )
    public void pointcutCheckLogin(CheckLogin checkLogin) {

    }

    @Around("pointcutCheckLogin(checkLogin)")
    public Object aroundCheckLogin(ProceedingJoinPoint joinPoint, final CheckLogin checkLogin) throws Throwable {
        UserInfo userInfo = MmkvHelper.getInstance().getUserInfo();
        if (userInfo == null) {
            ARouter.getInstance().build(RouterActivityPath.Login.PAGER_LOGIN).navigation();
            return null;
        } else {
            return joinPoint.proceed();
        }
    }
}
