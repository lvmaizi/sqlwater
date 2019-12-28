package com.sqlwater.context;

import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

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
