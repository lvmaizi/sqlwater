package com.sqlwater.web.interceptor;

import com.sqlwater.context.database.DataSourceContext;
import com.sqlwater.context.database.SqlDataSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Date 2019/12/3 20:49
 * @Version 1.0
 */

@Component
public class AllScopeInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        setCurrentDataSource(request.getSession());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
    public void setCurrentDataSource(HttpSession httpSession){
        DataSourceContext dataSourceContext = DataSourceContext.getInstance();
//        SqlDataSource sqlDataSource = dataSourceContext.dataSourceContext.get(httpSession);
//        if (sqlDataSource == null){
//            //TODO
//        }else {
//            dataSourceContext.currentDataSource.set(sqlDataSource);
//        }
    }
}
