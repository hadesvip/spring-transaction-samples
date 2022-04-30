package com.kevin.mybatis.samples.configuration;

import com.kevin.mybatis.samples.configuration.invoker.SchemaInitializerInvoker;
import com.kevin.mybatis.samples.configuration.properties.DataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author kevin
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration implements EnvironmentAware, InitializingBean, ApplicationContextAware {

    private Environment environment;

    private ApplicationContext applicationContext;

    private DataSourceProperties dataSourceProperties;


    @Bean(name = "dataSource", destroyMethod = "close")
    public HikariDataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariDataSource.setJdbcUrl(dataSourceProperties.getUrl());
        hikariDataSource.setUsername(dataSourceProperties.getUsername());
        hikariDataSource.setPassword(dataSourceProperties.getPassword());
        return hikariDataSource;
    }


    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(HikariDataSource hikariDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(hikariDataSource);
        return transactionManager;
    }


    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(HikariDataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(pathM3R.getResources("classpath*:mybatis/mapper/**/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.kevin.mybatis.samples.modules.**.repository");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return mapperScannerConfigurer;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    public void afterPropertiesSet() {
        dataSourceProperties = buildDataSourceProperties();
        String schema = environment.getProperty("spring.jdbc.schema");
        //初始化schema
        if (StringUtils.hasLength(schema)) {
            SchemaInitializerInvoker schemaInitializerInvoker = getSchemaInitializerInvoker();
            schemaInitializerInvoker.initSchema();
        }
    }

    private SchemaInitializerInvoker getSchemaInitializerInvoker() {
        return new SchemaInitializerInvoker(dataSourceProperties, applicationContext);
    }

    private DataSourceProperties buildDataSourceProperties() {
        String driverClassName = environment.getProperty("spring.jdbc.driver-class-name",
                "org.h2.Driver");
        String jdbcUrl = environment.getProperty("spring.jdbc.url",
                "jdbc:h2:mem:transaction_db;MODE=MySQL;DB_CLOSE_DELAY=-1;");
        String userName = environment.getProperty("spring.jdbc.username", "root");
        String password = environment.getProperty("spring.jdbc.password", "123456");
        String jdbcSchema = environment.getProperty("spring.jdbc.schema");

        return new DataSourceProperties(driverClassName, jdbcUrl, userName, password, jdbcSchema);
    }


}
