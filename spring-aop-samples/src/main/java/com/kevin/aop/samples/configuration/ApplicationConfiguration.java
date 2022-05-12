package com.kevin.aop.samples.configuration;

import com.kevin.aop.samples.modules.user.service.UserService;
import com.kevin.aop.samples.modules.user.service.impl.UserServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
@Configuration
@ComponentScan(basePackages = {"com.kevin.aop.samples"})
public class ApplicationConfiguration {


    @Bean
    public ProxyFactoryBean userServiceBean() {
        UserService target = new UserServiceImpl();
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(target);
        proxyFactoryBean.setTargetClass(UserService.class);
        proxyFactoryBean.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Logger.getGlobal().info("before...");
                Object result = invocation.proceed();
                Logger.getGlobal().info("after...");
                return result;
            }
        });
        return proxyFactoryBean;
    }

    @Bean
    public MethodInterceptor userServiceMethodInterceptor() {
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


    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("userSe*");
        beanNameAutoProxyCreator.setInterceptorNames("userServiceMethodInterceptor");
        beanNameAutoProxyCreator.setProxyTargetClass(true);
        return beanNameAutoProxyCreator;
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("getByUserId");
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(pointcut);
        defaultPointcutAdvisor.setAdvice(userServiceMethodInterceptor());
        return defaultPointcutAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        return defaultAdvisorAutoProxyCreator;
    }
}
