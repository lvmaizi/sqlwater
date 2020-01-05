package com.sqlwater.context.imp;

import com.sqlwater.context.Database;
import com.sqlwater.context.Exception.ServiceException;
import com.sqlwater.context.SqlApplication;
import com.sqlwater.context.SqlAutoGenerate;
import com.sqlwater.context.cache.SqlBaseDataContent;
import com.sqlwater.context.database.SqlDataSource;
import com.sqlwater.context.factory.SqlApplicationFactory;
import com.sqlwater.context.mysql.MysqlDataCacheService;
import com.sqlwater.context.mysql.MysqlDatabase;
import com.sqlwater.core.Constant;
import com.sqlwater.util.DynamicCompileUtil;
import com.sqlwater.util.MysqlDefaultParse;
import com.sqlwater.util.PackageUtil;
import com.sqlwater.util.UrlParseUtil;

import java.util.List;

/**
 * @Date 2019/11/29 17:21
 * @Version 1.0
 */
public class MysqlApplication implements SqlApplication {
    private static class SingletonInner {
        private static MysqlApplication mysqlApplication = new MysqlApplication();
    }
    public static SqlApplication getInstance() {
        return SingletonInner.mysqlApplication;
    }
    @Override
    public SqlDataSource init(String url,String userName,String password){
        //创建连接
        SqlDataSource sqlDataSource = SqlApplicationFactory.getSystemDateSource();
        sqlDataSource.setUrl(url);
        sqlDataSource.setUserName(userName);
        sqlDataSource.setPassword(password);
        if (sqlDataSource.testConnect()==false) {
            throw new ServiceException("数据库连接失败，请检查输入");
        }
        //初始化基础表
        SqlBaseDataContent sqlBaseDataContent = SqlBaseDataContent.getInstance();
        sqlBaseDataContent.put(sqlDataSource,getDatabaseByDataSources(sqlDataSource));
//        //逆向工程
//        SqlAutoGenerate sqlAutoGenerate = SqlApplicationFactory.getSystemSqlAutoGenerate();
//        sqlAutoGenerate.generateSqlContext(sqlDataSource.getDataSource());
//        //动态编译
//        String classPath = System.getProperty("user.dir")+ Constant.FILE_SEPARATOR +"src"+ Constant.FILE_SEPARATOR +
//                "main"+ Constant.FILE_SEPARATOR +"java"+ Constant.FILE_SEPARATOR +"com"+ Constant.FILE_SEPARATOR
//                +"sqlwater"+ Constant.FILE_SEPARATOR +"core"+ Constant.FILE_SEPARATOR +"mapper";
//        //测试生成jar
//        try {
//            PackageUtil.createTempJar(System.getProperty("user.dir")+ Constant.FILE_SEPARATOR + "newjar");
//        }catch (Exception e){
//
//        }
//        DynamicCompileUtil.singleCompile(classPath+ Constant.FILE_SEPARATOR + "UserMapper.java");
        return sqlDataSource;
    }

    /**
     * 根据SqlDataSources 初始化数据库基础数据
     */
    public Database getDatabaseByDataSources(SqlDataSource sqlDataSource) {
        //TODO 后续改变，先写死支持mysql
        Database database = new MysqlDatabase();
        try{
            MysqlDataCacheService mysqlDataCacheService = new MysqlDataCacheService();
            List list = mysqlDataCacheService.getTableData(sqlDataSource.getDataSource(), MysqlDefaultParse.getDataBaseName(sqlDataSource.getUrl()));
            database.setTables(list);
        }catch (Exception e){

        }
        return database;
    }
}
