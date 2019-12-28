package com.sqlwater.context;

import java.util.List;

/**
 * @Date 2019/12/4 18:19
 * @Version 1.0
 */
public interface Database {
    public void setTables(List<Table> list);
    public List<Table> getTables();
}
