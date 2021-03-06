package com.sqlwater.web.controller;

import com.sqlwater.context.SqlApplication;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.context.factory.SqlApplicationFactory;
import com.sqlwater.web.interceptor.DataSourceContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@Controller
public class LoginController {

    @RequestMapping("/login")
    public Object login(String url,String username,String password){
        if(StringUtils.isEmpty(url)){
            url = "jdbc:mysql://49.234.7.155:3306/fwh";
            username = "root";
            password = "fwh17839936646";
        }
        SqlApplication sqlApplication = SqlApplicationFactory.getSystemSqlApplication();
        try {
            SqlDataSource sqlDataSource = sqlApplication.init(url,username,password);
            HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            DataSourceContext.getInstance().dataSourceContext.put(httpSession,sqlDataSource);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
