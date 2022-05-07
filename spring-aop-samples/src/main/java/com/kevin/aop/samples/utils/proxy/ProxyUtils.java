package com.kevin.aop.samples.utils.proxy;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * 生成代理类工具
 *
 * @author kevin
 */
public final class ProxyUtils {

    public static boolean saveProxyClass(String path, String proxyClassName, Class[] interfaces) {
        if (proxyClassName == null || path == null) {
            return false;
        }
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyClassName, interfaces);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Logger.getGlobal().info("=======生成成功========");
        return false;

    }
}
