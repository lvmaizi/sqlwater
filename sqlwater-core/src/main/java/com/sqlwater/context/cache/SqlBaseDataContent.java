package com.sqlwater.context.cache;

import com.sqlwater.context.Database;
import com.sqlwater.context.Table;
import com.sqlwater.context.database.SqlDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date 2019/12/24 14:36
 * @Version 1.0
 */
public class SqlBaseDataContent {
    private static class SingleInner{
        public static SqlBaseDataContent sqlBaseDataContent = new SqlBaseDataContent();
    }
    public static SqlBaseDataContent getInstance() {
        return SingleInner.sqlBaseDataContent;
    }

    private SqlBaseDataContent(){}

    private Map<SqlDataSource, Database> databaseMap;

    /**
     * 数据库基础数据放入缓存
     * @param sqlDataSource
     * @param database
     */
    public void put(SqlDataSource sqlDataSource, Database database) {
        if(databaseMap==null){
            databaseMap = new HashMap();
        }
        databaseMap.put(sqlDataSource,database);
    }

    public Database get(SqlDataSource sqlDataSource){
        return databaseMap.get(sqlDataSource);
    }
}
