package com.sqlwater.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HtmlTest {
    @RequestMapping("hello")
    public String hello(){
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("xiaohan");
        list.add("456");
        return "/hello.html";
    }
}
