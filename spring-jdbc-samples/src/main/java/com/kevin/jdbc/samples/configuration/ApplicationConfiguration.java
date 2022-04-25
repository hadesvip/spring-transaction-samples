package com.kevin.jdbc.samples.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 全局应用配置
 *
 * @author kevin
 */
@Configuration
@Order(2)
@ComponentScan(basePackages = {"com.kevin.jdbc.samples"})
public class ApplicationConfiguration {





}
