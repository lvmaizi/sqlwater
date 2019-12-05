package com.sqlwater.context;

import java.util.List;

/**
 * @Date 2019/11/29 17:23
 * @Version 1.0
 */
public interface Table {
    public String getTableName();

    public void setTableName(String tableName);

    public List<Column> getColumns();

    public void setColumns(List<Column> columns);
}
