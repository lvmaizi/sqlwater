package com.sqlwater.context.mysql.mapper;

import com.sqlwater.context.Column;
import com.sqlwater.context.mysql.MysqlColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Date 2019/12/5 20:36
 * @Version 1.0
 */
public interface MysqlTableMapper {
    public List<MysqlColumn> selectColumnByTable(String databaseName,String tableName);
}
