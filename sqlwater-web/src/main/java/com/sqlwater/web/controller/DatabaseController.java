package com.sqlwater.web.controller;

import com.sqlwater.context.Table;
import com.sqlwater.web.service.WebDatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date 2019/12/24 18:51
 * @Version 1.0
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DatabaseController {
    @Autowired
    WebDatabaseOperation webDatabaseOperation;
    //查询当前数据库下的所有表信息
    @GetMapping("/tables")
    public List<Table> queryAllTable(){
        return webDatabaseOperation.queryTables();
    }
    //查询单个表约束信息
    @GetMapping("/tables/{tableName}")
    public Table queryTableByName(@PathVariable("tableName") String tableName){
        return webDatabaseOperation.queryTable(tableName);
    }
}
