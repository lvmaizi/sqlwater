package com.sqlwater.service;

import com.sqlwater.context.Database;
import com.sqlwater.context.cache.SqlBaseDataContent;
import com.sqlwater.context.database.SqlDataSource;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}
