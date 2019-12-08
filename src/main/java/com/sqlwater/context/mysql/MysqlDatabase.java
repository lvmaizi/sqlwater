package com.sqlwater.context.mysql;

import com.sqlwater.context.Database;
import com.sqlwater.context.Table;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.context.mysql.mapper.MysqlDatabaseMapper;
import com.sqlwater.context.mysql.mapper.MysqlTableMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Date 2019/12/4 18:23
 * @Version 1.0
 */
@Getter
@Setter
public class MysqlDatabase implements Database {
    private List<Table> tables;

    @Autowired
    private SqlDataSource sqlDataSource;

    @Autowired
    private MysqlDatabaseMapper mysqlDatabaseMapper;

    @Autowired
    private MysqlTableMapper mysqlTableMapper;

    @Override
    public List<Table> getTables() {
        return tables;
    }

    @Override
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }


    public void init(){
        //初始化表列表
        tables = mysqlDatabaseMapper.selectAll(sqlDataSource.getDatabaseName());
        for (Table table: tables) {
            table.setColumns(mysqlTableMapper.selectColumnByTable(table.getTableName()));
        }
    }
}
