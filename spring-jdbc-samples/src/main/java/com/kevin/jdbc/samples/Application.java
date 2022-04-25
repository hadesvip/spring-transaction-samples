package com.kevin.jdbc.samples;

import com.kevin.jdbc.samples.configuration.ApplicationConfiguration;
import com.kevin.jdbc.samples.service.UserService;
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
    }
}
