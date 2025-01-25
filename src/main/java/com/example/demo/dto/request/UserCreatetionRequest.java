package com.example.demo.dto.request;

import jakarta.validation.constraints.Size;

public class UserCreatetionRequest {
    @Size(min = 3, message = "username must be at least 3 characters")
    private String username;

    @Size(min = 8, message = "password must be at least 8 characters") //mật khẩu tối thiểu 8 kí tự
    private String password;
    private String firstName;
    private String lastName;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
