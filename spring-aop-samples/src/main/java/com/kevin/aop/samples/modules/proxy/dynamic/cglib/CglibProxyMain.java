package com.kevin.aop.samples.modules.proxy.dynamic.cglib;

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;
import com.kevin.aop.samples.modules.user.service.UserService;
import com.kevin.aop.samples.modules.user.service.impl.UserServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * cglib
 *
 * @author kevin
 */
public class CglibProxyMain {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code\\java_dev\\own\\spring-transaction" +
                "-samples\\spring-aop-samples\\src\\main\\resources");
        UserService target = new UserServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallbacks(new Callback[]{new UserServiceMethodInterceptor(target)});
        UserService userService = (UserService) enhancer.create();
        UserEntity userEntity = userService.getByUserId(1);
        Logger.getGlobal().info("userEntity:" + userEntity);
    }
}

class UserServiceMethodInterceptor implements MethodInterceptor{

    private  final UserService target;

    public UserServiceMethodInterceptor(UserService target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            Logger.getGlobal().info("【invoke method before】");
            Object result = methodProxy.invoke(target, objects);
            Logger.getGlobal().info("【invoke method after】");
            return result;
        }
    }
