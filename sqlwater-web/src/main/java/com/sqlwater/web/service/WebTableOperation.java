package com.sqlwater.web.service;

import com.sqlwater.context.Database;
import com.sqlwater.context.Table;
import com.sqlwater.context.cache.SqlBaseDataContent;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.context.model.Condition;
import com.sqlwater.service.CommonExample;
import com.sqlwater.service.TableOperation;
import com.sqlwater.web.interceptor.DataSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvmaizi
 * @version 1.0
 * @date 2020/1/5 13:41
 */
@Service
public class WebTableOperation {
    @Autowired
    TableOperation tableOperation;
    public void selectAll(){
        SqlDataSource sqlDataSource = DataSourceContext.getInstance().currentDataSource.get();
        //tableOperation.selectAll(sqlDataSource,"user");
    }
    //

    public void select(){
        List<Condition> conditions = new ArrayList<>();
        Condition condition = new Condition();
        condition.setColumnName("name");
        condition.setOperation("=");
        condition.setValue("fwh");
        conditions.add(condition);
        //强转
        SqlDataSource sqlDataSource = DataSourceContext.getInstance().currentDataSource.get();
        tableOperation.select(sqlDataSource,"user",conditions);
    }
}
