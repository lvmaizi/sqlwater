package com.sqlwater.context.factory;

import com.sqlwater.context.Database;
import com.sqlwater.context.SqlApplication;
import com.sqlwater.context.SqlAutoGenerate;
import com.sqlwater.context.database.DruidSqlDataSource;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.context.imp.MysqlApplication;
import com.sqlwater.context.mybatis.MybatisAdverseGenerate;
import com.sqlwater.context.mysql.MysqlDatabase;

/**
 * @Date 2019/12/3 18:35
 * @Version 1.0
 */
public class SqlApplicationFactory {
    /**
     * create sqlApplication for mysql
     * @return
     */
    public static SqlApplication createForMysql() {
        return MysqlApplication.getInstance();
    }

    /**
     * create DataSource for druid
     * @return
     */
    public static SqlDataSource createDruidDataSourceContext() {
        return new DruidSqlDataSource();
    }

    public static SqlApplication getSystemSqlApplication(){
        //TODO
        return createForMysql();
    }

    public static SqlDataSource getSystemDateSource(){
        //TODO
        return createDruidDataSourceContext();
    }
    public static SqlAutoGenerate getSystemSqlAutoGenerate(){
        //TODO
        return new MybatisAdverseGenerate();
    }
    public static Database getSystemDatabase(){
        //TODO
        return new MysqlDatabase();
    }
}
