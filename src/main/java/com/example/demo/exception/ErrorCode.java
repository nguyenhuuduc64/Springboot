package com.example.demo.exception;

public enum ErrorCode {
    USER_EXISTED(100, "User existed"),

    USER_INVALED(200,"username must be at least 3 characters"),
    PASSWORD_INVALED(300,"password must be at least 8 characters");




    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
