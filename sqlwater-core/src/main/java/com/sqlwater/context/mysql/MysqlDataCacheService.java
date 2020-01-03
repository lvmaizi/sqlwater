package com.sqlwater.context.mysql;

import com.sqlwater.context.Column;
import com.sqlwater.context.Table;
import com.sqlwater.context.mysql.mapper.MysqlDatabaseMapper;
import com.sqlwater.context.mysql.mapper.MysqlTableMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 2019/12/28 10:12
 * @Version 1.0
 */
@Component
public class MysqlDataCacheService {

    //表数据放入缓存
    public List getTableData(DataSource dataSource,String dataBaseName) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapping/*.xml"));
        SqlSessionFactory sessionFactory = factoryBean.getObject();
        List tables;
        try (SqlSession session = sessionFactory.openSession()) {
            MysqlDatabaseMapper mysqlDatabaseMapper = session.getMapper(MysqlDatabaseMapper.class);
            MysqlTableMapper mysqlTableMapper = session.getMapper(MysqlTableMapper.class);
            tables = mysqlDatabaseMapper.selectAll(dataBaseName);
            for (Object object:tables) {
                Table table = (Table)object;
                List<MysqlColumn> mysqlColumns = mysqlTableMapper.selectColumnByTable(dataBaseName,table.getTableName());
                table.setColumns(mysqlColumns.stream().map(e->(Column)e).collect(Collectors.toList()));
            }
        }
        return tables;
    }



}
