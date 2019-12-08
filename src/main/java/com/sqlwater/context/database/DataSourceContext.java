package com.sqlwater.context.database;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/12/3 20:22
 * @Version 1.0
 */
public class DataSourceContext {
    private static class SingletonInner{
        private static DataSourceContext dataSourceContext = new DataSourceContext();
    }
    public static DataSourceContext getInstance(){
        return SingletonInner.dataSourceContext;
    }
    public Map<HttpSession,SqlDataSource> dataSourceContext = new HashMap<HttpSession,SqlDataSource>();
    public ThreadLocal<SqlDataSource> currentDataSource = new ThreadLocal<SqlDataSource>();

    public void init(){

    }


}
