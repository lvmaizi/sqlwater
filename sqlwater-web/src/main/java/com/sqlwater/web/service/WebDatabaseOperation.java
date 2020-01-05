package com.sqlwater.web.service;

import com.sqlwater.context.Database;
import com.sqlwater.context.Table;
import com.sqlwater.context.cache.SqlBaseDataContent;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.web.interceptor.DataSourceContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lvmaizi
 * @version 1.0
 * @date 2020/1/5 16:17
 */
@Service
public class WebDatabaseOperation {
    /**
     * 查询当前数据源下的所有表
     */
    public List<Table> queryTables(){
        SqlDataSource sqlDataSource = DataSourceContext.getInstance().currentDataSource.get();
        Database database = SqlBaseDataContent.getInstance().get(sqlDataSource);
        return database.getTables();
    }
    /**
     * 查询单个表约束信息
     */
    public Table queryTable(String tableName){
        SqlDataSource sqlDataSource = DataSourceContext.getInstance().currentDataSource.get();
        Database database = SqlBaseDataContent.getInstance().get(sqlDataSource);
        List<Table> tables = database.getTables().stream().filter(e -> e.getTableName().equals(tableName)).collect(Collectors.toList());
        if(tables.size()>0)return tables.get(0);
        return null;
    }

}
