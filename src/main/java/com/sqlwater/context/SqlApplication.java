package com.sqlwater.context;

import java.sql.Connection;

/**
 * @Date 2019/11/29 17:19
 * @Version 1.0
 */
public interface SqlApplication {
    public void init(String url,String userName,String password);
}
