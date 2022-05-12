package com.kevin.aop.samples.modules.proxy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Logger;

/**
 * @author kevin
 */
@Aspect
public class UserServiceAspect {

    @Before("execution(public void com.kevin.aop.samples.modules.user.service.UserService.getByUserId())")
    public void invokeBefore(JoinPoint joinPoint) {
        Logger.getGlobal().info("【invoke before】");
    }


}
