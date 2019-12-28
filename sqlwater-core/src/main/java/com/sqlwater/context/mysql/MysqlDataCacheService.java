package com.sqlwater.context.mysql;

import com.sqlwater.context.mysql.mapper.MysqlDatabaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 2019/12/28 10:12
 * @Version 1.0
 */
@Component
public class MysqlDataCacheService {

    @Autowired
    private MysqlDatabaseMapper mysqlDatabaseMapper;
    //表数据放入缓存

}
