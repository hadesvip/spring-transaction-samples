package com.kevin.aop.samples.modules.proxy.jdk;

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;
import com.kevin.aop.samples.modules.user.service.UserService;
import com.kevin.aop.samples.modules.user.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public class JdkProxyRunner {

    public static void main(String[] args) {

        UserService target = new UserServiceImpl();

        Object proxy = Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Logger.getGlobal().info("【invoke method before】");
                        Object result = method.invoke(target, args);
                        Logger.getGlobal().info("【invoke method after】");
                        return result;
                    }
                });

        UserService userService = (UserService) proxy;
        UserEntity userEntity = userService.getByUserId(1);
        Logger.getGlobal().info("userEntity:" + userEntity);
    }
}
