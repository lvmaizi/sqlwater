package com.sqlwater.web;

import com.sqlwater.context.SqlApplication;
import com.sqlwater.context.factory.SqlApplicationFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/12/2 20:31
 * @Version 1.0
 */

@RestController
public class LoginController {
    @RequestMapping("/login")
    public Object login(String url,String username,String password){
        url = "jdbc:mysql://49.234.7.155:3306/fwh";
        username = "root";
        password = "fwh17839936646";
        SqlApplication sqlApplication = SqlApplicationFactory.getSystemSqlApplication();
        try {
            sqlApplication.init(url,username,password);
        }catch (Exception e){
            //TODO
        }
        return "登录成功";
    }
}
