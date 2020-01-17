package com.sqlwater.web.controller;

import com.sqlwater.web.service.WebDatabaseOperation;
import com.sqlwater.web.service.WebTableOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author lvmaizi
 * @version 1.0
 * @date 2020/1/5 13:42
 */
@RestController
public class TableController {
    @Autowired
    WebTableOperation webTableOperation;

    /**
     * 根据条件查询表中数据
     */
    @GetMapping("/table/{tableName}")
    public List<Map> queryTable(@RequestParam Map<String,Object> map,@PathVariable String tableName){
        System.out.println(map);
        return webTableOperation.select(map,tableName);
    }
    /**
     * 根据条件查询表中数据(分页)
     */
    @GetMapping("/table/{tableName}/{pageNum}")
    public List<Map> queryTable(@RequestParam Map<String,Object> map,@PathVariable String tableName,@PathVariable int pageNum){
        System.out.println(map);
        return webTableOperation.selectByPage(map,tableName,pageNum,100);
    }

}
