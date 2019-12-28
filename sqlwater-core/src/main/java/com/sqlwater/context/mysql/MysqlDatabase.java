package com.sqlwater.context.mysql;

import com.sqlwater.context.Database;
import com.sqlwater.context.Table;

import java.util.List;

/**
 * @Date 2019/12/4 18:23
 * @Version 1.0
 */
public class MysqlDatabase implements Database {
    private List<Table> tables;

    @Override
    public List<Table> getTables() {
        return tables;
    }

    @Override
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
