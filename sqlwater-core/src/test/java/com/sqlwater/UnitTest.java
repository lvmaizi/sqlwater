package com.sqlwater;


import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Date 2019/12/28 10:55
 * @Version 1.0
 */
@SpringBootTest
@ContextConfiguration
@SpringBootConfiguration
public class UnitTest {
    @Test
    public void testJar() throws Exception {
        System.out.println("hello");
        //mysqlDataCacheService.initTableData();
        Thread.sleep(1000000 * 10000L);
    }
}
