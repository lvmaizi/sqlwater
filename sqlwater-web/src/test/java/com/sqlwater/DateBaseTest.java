package com.sqlwater;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Date 2019/12/3 19:04
 * @Version 1.0
 */
public class DateBaseTest {
    @Test
    public void createConnection() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("fwh17839936646");
        dataSource.setUrl("jdbc:mysql://mysql57.rdsmkcc0pkuxka9.rds.su.baidubce.com:3306/fwh");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(10); // 启用监控统计功能  dataSource.setFilters("stat");// for mysql
        dataSource.setPoolPreparedStatements(false);
        Connection connection = dataSource.getConnection();
        System.out.println("oo");
    }
}
