package com.sqlwater.context.enumClass;

import lombok.Getter;
import lombok.Setter;

/**
 * @Date 2019/11/29 17:33
 * @Version 1.0
 */
public enum DataTypeEnum {
    MYSQL_INT("mysqlInt","mysql int type");

    private String code;
    private String desc;

    DataTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
