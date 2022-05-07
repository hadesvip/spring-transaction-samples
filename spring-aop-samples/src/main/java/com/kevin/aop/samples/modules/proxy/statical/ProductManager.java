package com.kevin.aop.samples.modules.proxy.statical;

import java.util.logging.Logger;

/**
 * RealSubject角色
 *
 * @author kevin
 */
public class ProductManager implements ProductOperator {

    @Override
    public void sale() {
        Logger.getGlobal().info("【ProductManager sale】");
    }

    @Override
    public void expand() {
        Logger.getGlobal().info("【ProductManager expand】");
    }
}
