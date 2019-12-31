package com.sqlwater.context.mybatis;

import com.sqlwater.context.SqlAutoGenerate;
//import org.mybatis.generator.api.MyBatisGenerator;
//import org.mybatis.generator.config.Configuration;
//import org.mybatis.generator.config.xml.ConfigurationParser;
//import org.mybatis.generator.exception.InvalidConfigurationException;
//import org.mybatis.generator.exception.XMLParserException;
//import org.mybatis.generator.internal.DefaultShellCallback;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/12/4 11:24
 * @Version 1.0
 */
public class MybatisAdverseGenerate implements SqlAutoGenerate {
    @Override
    public void generateSqlContext(DataSource dataSource) {
//        try{
//            List<String> warnings = new ArrayList<String>();
//            boolean overwrite = true;
//            // 指定配置文件
//            System.out.println(System.getProperty("user.dir"));
//            File configFile = new File(this.getClass().getResource("/").getPath()+ "src/main/resources/generatorConfig.xml");
//            ConfigurationParser cp = new ConfigurationParser(warnings);
//            Configuration config = cp.parseConfiguration(configFile);
//            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//            myBatisGenerator.generate(null);
//        }catch (Exception e){
//            System.out.println("yichangla");
//        }
    }
}
