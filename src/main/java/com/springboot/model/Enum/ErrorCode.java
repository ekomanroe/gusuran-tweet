package com.springboot.model.Enum;

/**
 * Created by eko.j.manurung on 12/18/2016.
 */
public enum ErrorCode {

    TWEET_NOT_FOUND("Your tweet doesn't found... "),
    MEMBER_NOT_FOUND("Member is not found, please register before"),
    ACCOUNT_NOT_FOUND("Account not found, please check your id"),
    INVALID_USERNAME_PASSWORD("Invalid username or password, please try again.. ");

    private String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String code() {
        return name();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
