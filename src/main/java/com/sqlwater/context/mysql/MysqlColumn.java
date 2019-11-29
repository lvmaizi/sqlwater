package com.sqlwater.context.mysql;

import com.sqlwater.context.Column;
import com.sqlwater.context.enumClass.DataTypeEnum;

/**
 * @Date 2019/11/29 17:29
 * @Version 1.0
 */
public class MysqlColumn implements Column {
    public String name;
    public String annotation;
    public com.sqlwater.context.enumClass.DataTypeEnum DataTypeEnum;
}
