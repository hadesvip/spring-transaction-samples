package com.kevin.jdbc.samples.repository.domain.entity;

/**
 * @author kevin
 */
public class UserEntity {

    private String userId;

    private String userName;

    private String phoneNumber;

    private String email;


    public UserEntity() {
    }

    public UserEntity(String userId, String userName, String phoneNumber, String email) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String toString() {
        return "{" + "\"userId\":\"" +
                userId + '\"' +
                ",\"userName\":\"" +
                userName + '\"' +
                ",\"phoneNumber\":\"" +
                phoneNumber + '\"' +
                ",\"email\":\"" +
                email + '\"' +
                '}';
    }
}
