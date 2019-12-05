package com.sqlwater;

//import com.sqlwater.context.mapper.UserMapper;
//import com.sqlwater.context.Model.User;
//import com.sqlwater.context.Model.UserExample;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/12/2 14:51
 * @Version 1.0
 */
@SpringBootTest
public class MybatisTests {
    @Test
    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // 指定配置文件
        System.out.println(System.getProperty("user.dir"));
        File configFile = new File("./target/classes/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    // 执行main方法以生成代码
    public static void main(String[] args) {
        try {
            MybatisTests generatorSqlmap = new MybatisTests();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 //   @Test
//    public void helloWorld() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            UserMapper mapper = session.getMapper(UserMapper.class);
//            UserExample example = new UserExample();
//            List<User> list = mapper.selectByExample(example);
//            System.out.println("kk");
//        }
//    }
//    @Test
//    public void helloWorld2() throws IOException {
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://mysql57.rdsmkcc0pkuxka9.rds.su.baidubce.com:3306/fwh";
//        String username="root";
//        String password="fwh17839936646";
//        //创建使用缓存池的数据源
//        /*
//         * <dataSource type="POOLED">
//                <property name="driver" value="${jdbc.driverClassName}"/>
//                <property name="url" value="${jdbc.url}"/>
//                <property name="username" value="${jdbc.username}"/>
//                <property name="password" value="${jdbc.password}"/>
//            </dataSource>
//         */
//        DataSource dataSource =new PooledDataSource(driver,url,username,password);
//        //创建事务
//        /*
//         * <transactionManager type="JDBC" />
//         */
//        TransactionFactory transactionFactory =  new JdbcTransactionFactory();
//
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
//        //加入资源
//        /*
//         * <mapper resource="ssm/BlogMapper.xml"/>
//         */
////        configuration.addMappers("UserMapper.class");
//        SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(configuration);
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            UserMapper mapper = session.getMapper(UserMapper.class);
//            UserExample example = new UserExample();
//            List<User> list = mapper.selectByExample(example);
//            System.out.println("kk");
//        }
//    }
//    @Test
//    public void helloWorld3() throws Exception {
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://mysql57.rdsmkcc0pkuxka9.rds.su.baidubce.com:3306/fwh";
//        String username="root";
//        String password="fwh17839936646";
//        //创建使用缓存池的数据源
//        /*
//         * <dataSource type="POOLED">
//                <property name="driver" value="${jdbc.driverClassName}"/>
//                <property name="url" value="${jdbc.url}"/>
//                <property name="username" value="${jdbc.username}"/>
//                <property name="password" value="${jdbc.password}"/>
//            </dataSource>
//         */
//        DataSource dataSource =new PooledDataSource(driver,url,username,password);
//
//
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapping/*.xml"));
//        SqlSessionFactory sessionFactory = factoryBean.getObject();
//        try (SqlSession session = sessionFactory.openSession()) {
//            UserMapper mapper = session.getMapper(UserMapper.class);
//            UserExample example = new UserExample();
//            List<User> list = mapper.selectByExample(example);
//            System.out.println("kk");
//        }
//    }
}
