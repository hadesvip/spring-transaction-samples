package com.kevin.jdbc.samples.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 事务配置
 *
 * @author kevin
 */
@Configuration
@Order(1)
@EnableTransactionManagement(proxyTargetClass = true)
public class TransactionConfiguration {


    @Bean
    public HikariDataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("org.h2.Driver");
        hikariDataSource.setJdbcUrl("jdbc:h2:mem:transaction_db;MODE=MySQL;DB_CLOSE_DELAY=-1;");
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("123456");
        return hikariDataSource;
    }



    @Bean
    public DataSourceTransactionManager getTransactionManager(HikariDataSource hikariDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(hikariDataSource);
        return transactionManager;
    }


    @Bean
    public JdbcTemplate getJdbcTemplate(HikariDataSource hikariDataSource) {
        return new JdbcTemplate(hikariDataSource);
    }


}
