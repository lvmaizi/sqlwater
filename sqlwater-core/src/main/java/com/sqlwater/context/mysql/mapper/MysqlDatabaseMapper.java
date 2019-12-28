package com.sqlwater.context.mysql.mapper;

import com.sqlwater.context.Table;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date 2019/12/4 20:04
 * @Version 1.0
 */
public interface MysqlDatabaseMapper {
    public List<Table> selectAll(String dataBaseName);
}
