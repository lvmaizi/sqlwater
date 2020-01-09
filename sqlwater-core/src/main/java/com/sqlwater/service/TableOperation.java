package com.sqlwater.service;

import com.sqlwater.context.Database;
import com.sqlwater.context.Table;
import com.sqlwater.context.cache.SqlBaseDataContent;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.context.model.Condition;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lvmaizi
 * @version 1.0
 * @date 2020/1/5 13:19
 */
@Service
public class TableOperation {
    /**
     * 查询当前表的内容
     */
    public void selectAll(SqlDataSource sqlDataSource,String tableName){
        ResultSet resultSet = null;
        try{
            Connection connection = sqlDataSource.getConnection();
            String sql = "SELECT name,age FROM USER";
            PreparedStatement ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /**
     * 查询当前表的内容
     */
    public void select(SqlDataSource sqlDataSource, String tableName, List<Condition> conditions) {
        Database database = SqlBaseDataContent.getInstance().get(sqlDataSource);
        List<Table> tables = database.getTables().stream().filter(e -> e.getTableName().equals(tableName)).collect(Collectors.toList());
        if(tables.size()>0){

            String sql = SqlBuilder.buildQuerySql(tables.get(0),conditions);
            ResultSet resultSet = null;
            try{
                Connection connection = sqlDataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                resultSet = ps.executeQuery();
                while(resultSet.next()){
                    System.out.println(resultSet.getString(1));

                }
            }catch (Exception e){

            }
        }
    }

}
