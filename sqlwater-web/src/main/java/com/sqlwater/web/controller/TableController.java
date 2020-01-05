package com.sqlwater.web.controller;

import com.sqlwater.web.service.WebTableOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/table")
    public void queryTable(){

    }

}
