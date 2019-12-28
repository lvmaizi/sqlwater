package com.sqlwater.context.database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Date 2019/12/3 19:36
 * @Version 1.0
 */
public interface SqlDataSource {


    public void init();

    public Boolean testConnect();

    public Connection getConnection() throws SQLException;

    public DataSource getDataSource();

    public String getUrl();

    public String getDriver();

    public String getUserName();

    public String getPassword();

    public void setUrl(String url);

    public void setDriver(String driver);

    public void setUserName(String userName);

    public void setPassword(String password);

    public void setDataSource(DataSource dataSource);
}
