package com.kevin.aop.samples.utils.proxy;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public class GetBooleanAction implements java.security.PrivilegedAction<Boolean> {

    private final String theProp;

    /**
     * Constructor that takes the name of the system property whose boolean
     * value needs to be determined.
     *
     * @param theProp the name of the system property.
     */
    public GetBooleanAction(String theProp) {
        this.theProp = theProp;
    }

    /**
     * Determines the boolean value of the system property whose name was
     * specified in the constructor.
     *
     * @return the <code>Boolean</code> value of the system property.
     */
    @Override
    public Boolean run() {
        return Boolean.getBoolean(theProp);
    }
}
