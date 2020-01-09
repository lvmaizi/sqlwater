package com.sqlwater.context.model;

/**
 * @Date 2020/1/9 16:37
 * @Version 1.0
 */
public class Condition {
    //列名
    public String columnName;
    //条件
    public String operation;
    //值
    public String value;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
