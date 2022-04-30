package com.kevin.mybatis.samples.configuration.properties;

/**
 * @author kevin
 */
public class DataSourceProperties {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

    private String jdbcSchema;


    public DataSourceProperties(String driverClassName, String url, String username, String password, String jdbcSchema) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
        this.jdbcSchema = jdbcSchema;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName == null ? null : driverClassName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getJdbcSchema() {
        return jdbcSchema;
    }

    public void setJdbcSchema(String jdbcSchema) {
        this.jdbcSchema = jdbcSchema == null ? null : jdbcSchema.trim();
    }

}
