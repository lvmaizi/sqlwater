package com.sqlwater.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * @Date 2019/12/4 16:58
 * @Version 1.0
 */
public class PackageUtil {



    /**
     * Create a temp jar file in "java.io.tmpdir".
     *
     * @param root
     * @return
     * @throws IOException
     */
    public static File createTempJar(String root) throws IOException {
        if (!new File(root).exists()) {
            return null;
        }
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().putValue("Manifest-Version", "1.0");
        manifest.getMainAttributes().putValue("Main-Class", "Show");//指定Main Class

        final File jarFile = File.createTempFile("edwin-", ".jar", new File(System
                .getProperty("user.dir")));

        //程序结束后，通过以下代码删除生成的jar文件
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			public void run() {
//				jarFile.delete();
//			}
//		});

        JarOutputStream out = new JarOutputStream(new FileOutputStream(jarFile),
                manifest);
        createTempJarInner(out, new File(root), "");
        out.flush();
        out.close();
        return jarFile;
    }

    private static void createTempJarInner(JarOutputStream out, File f,
                                           String base) throws IOException {
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            if (base.length() > 0) {
                base = base + "/";
            }
            for (int i = 0; i < fl.length; i++) {
                createTempJarInner(out, fl[i], base + fl[i].getName());
            }
        } else {
            out.putNextEntry(new JarEntry(base));
            FileInputStream in = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            int n = in.read(buffer);
            while (n != -1) {
                out.write(buffer, 0, n);
                n = in.read(buffer);
            }
            in.close();
        }
    }
}
