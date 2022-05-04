package com.kevin.aop.samples.modules.proxy.cglib;

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;
import com.kevin.aop.samples.modules.user.service.UserService;
import com.kevin.aop.samples.modules.user.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * cglib
 *
 * @author kevin
 */
public class CglibProxyRunner {

    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallbacks(new Callback[]{
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        Logger.getGlobal().info("【invoke method before】");
                        Object result = methodProxy.invoke(target, objects);
                        Logger.getGlobal().info("【invoke method after】");
                        return result;
                    }
                }
        });

        UserService userService = (UserService) enhancer.create();
        UserEntity userEntity = userService.getByUserId(1);
        Logger.getGlobal().info("userEntity:" + userEntity);
    }

}
