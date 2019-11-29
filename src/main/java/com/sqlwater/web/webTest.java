package com.sqlwater.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Date 2019/11/29 17:53
 * @Version 1.0
 */
public class webTest {
    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "my first test";
    }
}
