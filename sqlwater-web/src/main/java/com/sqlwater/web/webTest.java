package com.sqlwater.web;

import com.sqlwater.service.ServiceTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/11/29 17:53
 * @Version 1.0
 */
@RestController
public class webTest {

    private ServiceTest serviceTest;

    @RequestMapping("/test")

    public String test() {
        //List<User> list = serviceTest.select();
        return "my first test";
    }

    @RequestMapping("testJson")
    public User testJson() {
        //List<User> list = serviceTest.select();
        User user = new User();
        user.age = 12;
        user.name = "fanwenaho";
        return user;
    }
}
