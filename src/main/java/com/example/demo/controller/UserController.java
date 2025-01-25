package com.example.demo.controller;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.UserCreatetionRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //một thành phần chịu trách nhiệm xử lý các yêu cầu HTTP (HTTP requests) và trả về dữ liệu trực tiếp dưới dạng JSON, XML, hoặc các định dạng khác.
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreatetionRequest request){ // @Valid giúp spring biết cần validate cho hàm này

        ApiResponse<User> response = new ApiResponse<>();
        response.setCode(100);
        response.setMessage("user has been created");
        response.setResult(userService.createUser(request));
        return response;

    }

    @GetMapping //lấy danh sách users nhưng vì users lặp lại quá nhiều nên ta @RequestMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    //lấy 1 user dựa trên id
    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return "user has been deleted";
    }
}
