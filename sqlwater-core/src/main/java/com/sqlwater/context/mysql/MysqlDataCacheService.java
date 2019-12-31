package com.sqlwater.context.mysql;

import com.sqlwater.context.Table;
import com.sqlwater.context.mysql.mapper.MysqlDatabaseMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * @Date 2019/12/28 10:12
 * @Version 1.0
 */
@Component
public class MysqlDataCacheService {

    //表数据放入缓存
    public void initTableData() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://mysql57.rdsmkcc0pkuxka9.rds.su.baidubce.com:3306/fwh";
        String username="root";
        String password="fwh17839936646";
        //创建使用缓存池的数据源
        /*
         * <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driverClassName}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
         */
        DataSource dataSource =new PooledDataSource(driver,url,username,password);


        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapping/*.xml"));
        SqlSessionFactory sessionFactory = factoryBean.getObject();
        try (SqlSession session = sessionFactory.openSession()) {
            MysqlDatabaseMapper mapper = session.getMapper(MysqlDatabaseMapper.class);
            List tables = mapper.selectAll("fwh");
            System.out.println("kk");
        }
    }

}
