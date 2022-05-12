package com.kevin.aop.samples.modules.proxy.spring.support;

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;
import com.kevin.aop.samples.modules.user.service.UserService;
import com.kevin.aop.samples.modules.user.service.impl.UserServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

import java.util.logging.Logger;

/**
 * Spring 对代理的支持
 *
 * @author kevin
 */
public class SpringProxySupportMain {

    public static void main(String[] args) {

        UserService target = new UserServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.setTargetClass(UserService.class);
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Logger.getGlobal().info("before...");
                Object result = invocation.proceed();
                Logger.getGlobal().info("after...");
                return result;
            }
        });
        UserService proxy = (UserService)proxyFactory.getProxy();
        UserEntity userEntity = proxy.getByUserId(1);
        Logger.getGlobal().info(userEntity.toString());
    }
}
