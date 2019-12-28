package com.sqlwater.context.mysql.mapper;

import com.sqlwater.context.Column;

import java.util.List;

/**
 * @Date 2019/12/5 20:36
 * @Version 1.0
 */
public interface MysqlTableMapper {
    public List<Column> selectColumnByTable(String tableName);
}
