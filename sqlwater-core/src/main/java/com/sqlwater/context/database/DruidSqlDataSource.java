package com.sqlwater.context.database;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Date 2019/12/3 19:40
 * @Version 1.0
 */

public class DruidSqlDataSource implements SqlDataSource {
    public String url;
    public String driver = "com.mysql.jdbc.Driver";
    public String userName;
    public String password;
    public DataSource dataSource;
    public String databaseName;

    @Override
    public void init(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(10); // 启用监控统计功能  dataSource.setFilters("stat");// for mysql
        dataSource.setPoolPreparedStatements(false);
        this.dataSource = dataSource;
    }

    @Override
    public Boolean testConnect(){
        if (dataSource == null){
            init();
        }
        try {
            dataSource.getConnection();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (dataSource == null){
            init();
        }
        return dataSource.getConnection();
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String getDatabaseName() { return databaseName; }

    @Override
    public void setDatabaseName(String databaseName) { this.databaseName = databaseName; }

}
