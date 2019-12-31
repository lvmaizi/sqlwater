package com.sqlwater.web;

import com.sqlwater.context.mysql.MysqlDataCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/12/30 10:47
 * @Version 1.0
 */
@RestController
public class InitTest {
    @Autowired
    private MysqlDataCacheService mysqlDataCacheService;

    @RequestMapping("init")
    public String init() {
        try{
            mysqlDataCacheService.initTableData();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "init success";
    }
}
