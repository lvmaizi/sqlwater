package com.sqlwater.context.mysql;

import com.sqlwater.context.Column;
import com.sqlwater.context.enumClass.DataTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Date 2019/11/29 17:29
 * @Version 1.0
 */
@Getter
@Setter
public class MysqlColumn implements Column {
    public String name;
    public String comment;
    public String type;

}
