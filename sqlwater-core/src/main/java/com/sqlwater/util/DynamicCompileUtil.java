package com.sqlwater.util;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.util.Arrays;

/**
 * @Date 2019/12/4 14:52
 * @Version 1.0
 */
public class DynamicCompileUtil {
    //batch compile
    public static void batchCompile(String classPath) {
        //TODO
//        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
//        int status = javac.run(null, null, null,classPath);
//        if(status!=0){
//            System.out.println("没有编译成功！");
//        }

    }
    //single compile
    public static void singleCompile(String classPath) {
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        int status = javac.run(null, null, null,classPath);
        if(status!=0){
            System.out.println("没有编译成功！");
        }
    }
}
