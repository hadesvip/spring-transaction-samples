package com.kevin.aop.samples;

import com.kevin.aop.samples.modules.user.service.UserService;
import com.kevin.aop.samples.utils.proxy.ProxyUtils;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public class AopApplication {

    public static void main(String[] args) {
        String path = "D:\\code\\java_dev\\own\\spring-transaction-samples\\spring-aop-samples\\src\\main\\resources" +
                "\\$Proxy0.class";
        ProxyUtils.saveProxyClass(path, "UserService", new Class[]{UserService.class});
    }

}