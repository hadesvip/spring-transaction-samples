package com.kevin.mybatis.samples.configuration.invoker;

import com.kevin.mybatis.samples.configuration.event.DataSourceSchemaCreatedEvent;
import com.kevin.mybatis.samples.configuration.properties.DataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.config.SortedResourcesFactoryBean;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数据源初始化
 *
 * @author kevin
 */
public class SchemaInitializerInvoker implements ApplicationListener<DataSourceSchemaCreatedEvent> {

    private final DataSourceProperties properties;

    private final ResourceLoader resourceLoader;


    public SchemaInitializerInvoker(DataSourceProperties properties, ResourceLoader resourceLoader) {
        this.properties = properties;
        this.resourceLoader = resourceLoader;
    }

    public void initSchema() {
        String jdbcSchema = properties.getJdbcSchema();
        List<Resource> resourceList = getResourceList(jdbcSchema);
        runScripts(resourceList);
    }

    void runScripts(List<Resource> resourceList) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(false);
        populator.setSqlScriptEncoding("UTF-8");
        populator.addScripts((Resource[]) (resourceList.toArray()));
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        DatabasePopulatorUtils.execute(populator, dataSource);
    }


    private List<Resource> getResourceList(String schemas) {
        List<Resource> resourceList = new ArrayList<>();
        String[] schemaArray = schemas.split(",");
        for (String schema : schemaArray) {
            for (Resource resource : doGetResources(schema)) {
                if (resource.exists()) {
                    resourceList.add(resource);
                }
            }
        }
        return resourceList;
    }

    private Resource[] doGetResources(String schemaLocation) {
        try {
            SortedResourcesFactoryBean factory = new SortedResourcesFactoryBean(
                    this.resourceLoader, Collections.singletonList(schemaLocation));
            factory.afterPropertiesSet();
            return factory.getObject();
        } catch (Exception ex) {
            throw new IllegalStateException("Unable to load resources from " + schemaLocation,
                    ex);
        }
    }

    @Override
    public void onApplicationEvent(DataSourceSchemaCreatedEvent event) {

    }
}
