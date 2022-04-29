package com.kevin.jdbc.samples;

import com.kevin.jdbc.samples.configuration.ApplicationConfiguration;
import com.kevin.jdbc.samples.modulars.user.repository.domain.entity.UserEntity;
import com.kevin.jdbc.samples.modulars.user.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * @author kevin
 */
public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationApplicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UserService userService = annotationApplicationContext.getBean(UserService.class);
        Logger.getGlobal().info("userService:" + userService);

        userService.save(new UserEntity("001", "admin",
                "13584040989", "admin@126.com"));
        UserEntity userEntity = userService.queryByUserId("001");
        Logger.getGlobal().info("检索结果:" + userEntity);

    }
}
