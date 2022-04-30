package com.kevin.mybatis.samples;

import com.kevin.mybatis.samples.configuration.ApplicationConfiguration;
import com.kevin.mybatis.samples.modules.user.domain.entity.UserEntity;
import com.kevin.mybatis.samples.modules.user.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * 入口
 *
 * @author kevin
 */
public class MybatisApplication {

    public static void main(String[] args) {
        Logger.getGlobal().info("=====项目开始启动=====");

        AnnotationConfigApplicationContext annotationApplicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);


        UserService userService = annotationApplicationContext.getBean(UserService.class);
        Logger.getGlobal().info("用户服务Bean:" + userService);


        UserEntity userEntity = new UserEntity();
        userEntity.setUserNo("admin");
        userEntity.setUserName("张三");
        userEntity.setState("正常");
        userEntity.setEmail("admin@126.com");
        userEntity.setPhoneNumber("13584040909");
        userService.save(userEntity);


        UserEntity queryEntity = userService.queryByUserNo("admin");
        Logger.getGlobal().info("用户信息:" + queryEntity);


        Logger.getGlobal().info("=====项目已停止=====");
    }

}
