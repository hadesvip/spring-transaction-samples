package com.kevin.mybatis.samples.configuration.invoker;

import com.kevin.mybatis.samples.configuration.properties.DataSourceProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.config.SortedResourcesFactoryBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数据源初始化
 *
 * @author kevin
 */
public class SchemaInitializerInvoker {

    private final DataSourceProperties properties;

    private final ResourceLoader resourceLoader;


    public SchemaInitializerInvoker(DataSourceProperties properties, ResourceLoader resourceLoader) {
        this.properties = properties;
        this.resourceLoader = resourceLoader;
    }

    public void initSchema() {
        String jdbcSchema = properties.getJdbcSchema();
        String[] schemaArray = jdbcSchema.split(",");
        List<Resource> resourceList = new ArrayList<>(schemaArray.length);

    }

    void runScripts() {

    }


    private Resource[] doGetResources(String location) {
        try {
            SortedResourcesFactoryBean factory = new SortedResourcesFactoryBean(
                    this.resourceLoader, Collections.singletonList(location));
            factory.afterPropertiesSet();
            return factory.getObject();
        } catch (Exception ex) {
            throw new IllegalStateException("Unable to load resources from " + location,
                    ex);
        }
    }

}
