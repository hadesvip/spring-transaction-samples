package com.kevin.mybatis.samples;

import com.kevin.mybatis.samples.configuration.ApplicationConfiguration;
import com.kevin.mybatis.samples.modular.user.service.UserService;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * @author kevin
 */
public class Application {

    public static void main(String[] args) {
        Logger.getGlobal().info("=====项目开始启动=====");

        AnnotationConfigApplicationContext annotationApplicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);


        UserService userService = annotationApplicationContext.getBean(UserService.class);
        Logger.getGlobal().info("用户服务Bean:" + userService);

        Logger.getGlobal().info("=====项目已停止=====");
    }

}
