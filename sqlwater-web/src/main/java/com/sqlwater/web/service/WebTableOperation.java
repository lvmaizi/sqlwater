package com.sqlwater.web.service;

import com.sqlwater.context.Column;
import com.sqlwater.context.Database;
import com.sqlwater.context.Table;
import com.sqlwater.context.cache.SqlBaseDataContent;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.context.model.Condition;
import com.sqlwater.service.CommonExample;
import com.sqlwater.service.TableOperation;
import com.sqlwater.web.interceptor.DataSourceContext;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lvmaizi
 * @version 1.0
 * @date 2020/1/5 13:41
 */
@Service
public class WebTableOperation {
    @Autowired
    TableOperation tableOperation;
    @Autowired
    WebDatabaseOperation webDatabaseOperation;
    public void selectAll(){
        SqlDataSource sqlDataSource = DataSourceContext.getInstance().currentDataSource.get();
        //tableOperation.selectAll(sqlDataSource,"user");
    }
    //

    public List<Map> select(Map<String,Object> map,String tableName){
        List<Condition> conditions = new ArrayList<>();
        Table table = webDatabaseOperation.queryTable(tableName);
        for (Column column:table.getColumns()){
            if(map.get(column.getName())!=null){
                Condition condition = new Condition();
                condition.setColumnName(column.getName());
                condition.setOperation((String) map.get(column.getName()+"Qualify"));
                condition.setValue((String) map.get(column.getName()));
                if(!StringUtils.isEmpty(map.get(column.getName()))) {
                    conditions.add(condition);
                }
            }
        }
        //强转
        SqlDataSource sqlDataSource = DataSourceContext.getInstance().currentDataSource.get();
        return tableOperation.select(sqlDataSource,tableName,conditions);
    }

    public List<Map> selectByPage(Map<String,Object> map,String tableName,int pageNum,int pageSize){
        List<Condition> conditions = new ArrayList<>();
        Table table = webDatabaseOperation.queryTable(tableName);
        for (Column column:table.getColumns()){
            if(map.get(column.getName())!=null){
                Condition condition = new Condition();
                condition.setColumnName(column.getName());
                condition.setOperation((String) map.get(column.getName()+"Qualify"));
                condition.setValue((String) map.get(column.getName()));
                if(!StringUtils.isEmpty(map.get(column.getName()))) {
                    conditions.add(condition);
                }
            }
        }
        //强转
        SqlDataSource sqlDataSource = DataSourceContext.getInstance().currentDataSource.get();
        return tableOperation.selectByPage(sqlDataSource,tableName,conditions,pageNum,pageSize);
    }
}
