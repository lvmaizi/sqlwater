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
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
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
    public List<Map> select(SqlDataSource sqlDataSource, String tableName, List<Condition> conditions) {
        List<Map> mapList = new ArrayList<>();
        Database database = SqlBaseDataContent.getInstance().get(sqlDataSource);
        List<Table> tables = database.getTables().stream().filter(e -> e.getTableName().equals(tableName)).collect(Collectors.toList());
        if(tables.size()>0){

            String sql = SqlBuilder.buildQuerySql(tables.get(0),conditions);
            ResultSet resultSet = null;
            try{
                Connection connection = sqlDataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                resultSet = ps.executeQuery();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                while(resultSet.next()){
                    System.out.println(resultSet.getString(1));
                    Map map = new HashMap();
                    for (int i=1; i<=resultSetMetaData.getColumnCount(); i++){
                        map.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
                    }
                    mapList.add(map);
                }
            }catch (Exception e){

            }
        }
        return mapList;
    }
    /**
     * 查询当前表的内容(分页)
     */
    public List<Map> selectByPage(SqlDataSource sqlDataSource, String tableName, List<Condition> conditions, int pageNum, int pageSize) {
        List<Map> mapList = new ArrayList<>();
        Database database = SqlBaseDataContent.getInstance().get(sqlDataSource);
        List<Table> tables = database.getTables().stream().filter(e -> e.getTableName().equals(tableName)).collect(Collectors.toList());
        if(tables.size()>0){

            String sql = SqlBuilder.buildPageQuerySql(tables.get(0),conditions,pageNum,pageSize);
            ResultSet resultSet = null;
            try{
                Connection connection = sqlDataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                resultSet = ps.executeQuery();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                while(resultSet.next()){
                    System.out.println(resultSet.getString(1));
                    Map map = new HashMap();
                    for (int i=1; i<=resultSetMetaData.getColumnCount(); i++){
                        map.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
                    }
                    mapList.add(map);
                }
            }catch (Exception e){

            }
        }
        return mapList;
    }

}
