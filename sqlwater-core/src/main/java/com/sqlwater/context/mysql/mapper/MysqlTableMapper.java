package com.sqlwater.context.mysql.mapper;

import com.sqlwater.context.Column;
import com.sqlwater.context.mysql.MysqlColumn;

import java.util.List;

/**
 * @Date 2019/12/5 20:36
 * @Version 1.0
 */
public interface MysqlTableMapper {
    public List<MysqlColumn> selectColumnByTable(String databaseName,String tableName);
}
