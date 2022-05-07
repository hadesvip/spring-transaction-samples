package com.kevin.aop.samples.modules.proxy.dynamic.jdk;

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;
import com.kevin.aop.samples.modules.user.service.UserService;
import com.kevin.aop.samples.modules.user.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

/**
 * JDK动态代理实现
 *
 * @author kevin
 */
public class JDKProxyMain {

    public static void main(String[] args) {

        UserService target = new UserServiceImpl();

        Object proxy = Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String info = String.format("【invoke method】 proxyClass:%s,methodName:%s,args:%s",
                                proxy.getClass(),
                                method.getName(), args);
                        Logger.getGlobal().info(info);
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
