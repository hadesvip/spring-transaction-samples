package com.kevin.aop.samples.modules.proxy.spring.support;

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;
import com.kevin.aop.samples.modules.user.service.UserService;
import com.kevin.aop.samples.modules.user.service.impl.UserServiceImpl;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public class AdvisorMain {
    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                return new StaticMethodMatcherPointcut() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return method.getName().equals("getByUserId");
                    }
                };
            }
            @Override
            public Advice getAdvice() {
                return new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation invocation) throws Throwable {
                        Logger.getGlobal().info("before...");
                        Object result = invocation.proceed();
                        Logger.getGlobal().info("after...");
                        return result;
                    }
                };
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }
        });

        UserService proxy = (UserService) proxyFactory.getProxy();
        UserEntity userEntity = proxy.getByUserId(1);
        Logger.getGlobal().info(userEntity.toString());
    }
}
