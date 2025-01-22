package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //đánh dấu là nơi handle tất cả exception
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class) //xử lý khi có bất cứ ngoại lệ kiểu RuntimeException xảy ra
    ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
        //trả về đoạn message trong hàm getUser tại userService


    }
}
