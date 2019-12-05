package com.sqlwater.context.mysql;

import com.sqlwater.context.Column;
import com.sqlwater.context.Table;

import java.util.List;

/**
 * @Date 2019/11/29 17:24
 * @Version 1.0
 */
public class MysqlTable implements Table {
    public String tableName;
    public List<Column> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
