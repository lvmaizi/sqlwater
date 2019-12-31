package com.sqlwater.context;


import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Date 2019/12/4 11:21
 * @Version 1.0
 */
public interface SqlAutoGenerate {
    public void generateSqlContext(DataSource dataSource);
}
