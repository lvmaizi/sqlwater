package com.sqlwater.context;

/**
 * @Date 2019/11/29 17:28
 * @Version 1.0
 */
public interface Column {
    public String getName();

    public void setName(String name);

    public String getComment();

    public void setComment(String comment);

    public String getType();

    public void setType(String type);
}
