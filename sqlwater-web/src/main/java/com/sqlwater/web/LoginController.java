package com.sqlwater.web;

import com.sqlwater.context.SqlApplication;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.context.factory.SqlApplicationFactory;
import com.sqlwater.web.interceptor.DataSourceContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

/**
 * @Date 2019/12/2 20:31
 * @Version 1.0
 */

@RestController
public class LoginController {
//    @PostConstruct
//    public void init(){login(null,null,null);}
    @RequestMapping("/login")
    public Object login(String url,String username,String password){
        url = "jdbc:mysql://49.234.7.155:3306/fwh";
        username = "root";
        password = "fwh17839936646";
        SqlApplication sqlApplication = SqlApplicationFactory.getSystemSqlApplication();
        try {
            SqlDataSource sqlDataSource = sqlApplication.init(url,username,password);
            HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            DataSourceContext.getInstance().dataSourceContext.put(httpSession,sqlDataSource);
        }catch (Exception e){
            //TODO
        }
        return "login success";
    }
}
