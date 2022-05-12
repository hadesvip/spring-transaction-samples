package com.kevin.aop.samples.modules.user.domain.entity;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author kevin
 */
public class UserEntity {

    private Integer userId;

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserEntity(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserEntity() {
    }

    @Override
    public String toString() {
        return "{"
                + "\"userId\":"
                + userId
                + ",\"userName\":\""
                + userName + '\"'
                + '}';
    }
}
