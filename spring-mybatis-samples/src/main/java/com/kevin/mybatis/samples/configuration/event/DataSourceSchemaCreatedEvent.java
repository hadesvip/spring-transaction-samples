package com.kevin.mybatis.samples.configuration.event;

import org.springframework.context.ApplicationEvent;

import javax.sql.DataSource;

/**
 * @author kevin
 */
public class DataSourceSchemaCreatedEvent extends ApplicationEvent {

    public DataSourceSchemaCreatedEvent(DataSource source) {
        super(source);
    }
}
