package com.kevin.aop.samples.modules.proxy.statical;

/**
 * client
 *
 * @author kevin
 */
public class ProductClient {

    public static void main(String[] args) {

        ProductOperator productOperator = new BusinessAgent();

        productOperator.sale();

        productOperator.expand();


    }


}
