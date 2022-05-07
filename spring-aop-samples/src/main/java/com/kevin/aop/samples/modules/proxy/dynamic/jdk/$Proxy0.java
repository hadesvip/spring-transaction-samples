package com.kevin.aop.samples.modules.proxy.dynamic.jdk;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.kevin.aop.samples.modules.user.domain.entity.UserEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * JDK动态代理生成的代理类
 */
public final class $Proxy0 extends Proxy implements com.kevin.aop.samples.modules.user.service.UserService {

    /**
     * 这个四个方法分别是:equals、toString、getByUserId、hashCode
     */
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;

    /**
     * 构造方法接收一个InvocationHandler类型的参数
     * @param var1
     */
    public $Proxy0(InvocationHandler var1) {
        super(var1);
    }

    @Override
    public final boolean equals(Object var1) {
        try {
            return (Boolean) super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    @Override
    public final String toString() {
        try {
            //supper.h.invoke 调用的是InvocationHandler接口的实现类，也就是UserServiceInvocationHandler
            //所以会调用UserServiceInvocationHandler#toString()方法
            //invoke方法的第一个参数是代理对象本身。
            return (String) super.h.invoke(this, m2, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    @Override
    public final UserEntity getByUserId(Integer var1) {
        try {
            return (UserEntity) super.h.invoke(this, m3, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    @Override
    public final int hashCode() {
        try {
            return (Integer) super.h.invoke(this, m0, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m3 = Class.forName("com.kevin.aop.samples.modules.user.service.UserService").getMethod("getByUserId",
                    Class.forName("java.lang.Integer"));
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}
