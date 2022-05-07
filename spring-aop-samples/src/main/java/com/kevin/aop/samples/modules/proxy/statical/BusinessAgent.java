package com.kevin.aop.samples.modules.proxy.statical;

import java.util.logging.Logger;

/**
 * proxy角色
 *
 * @author kevin
 */
public class BusinessAgent implements ProductOperator {

    private final ProductManager productManager;

    public BusinessAgent() {
        this.productManager = new ProductManager();
    }

    @Override
    public void sale() {
        Logger.getGlobal().info("【BusinessAgent sale】");
        productManager.sale();
    }

    @Override
    public void expand() {
        Logger.getGlobal().info("【BusinessAgent expand】");
        productManager.expand();
    }
}
