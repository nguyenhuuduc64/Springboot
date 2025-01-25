package com.example.demo.exception;

import com.example.demo.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //đánh dấu là nơi handle tất cả exception
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class) //xử lý khi có bất cứ ngoại lệ kiểu RuntimeException xảy ra
    ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException e) {
        ApiResponse response = new ApiResponse();
        response.setMessage(e.getMessage());
        response.setCode(500);
        return ResponseEntity.status(500).body(response);
        //trả về đoạn message trong hàm getUser tại userService
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException e) {
        ApiResponse response = new ApiResponse();

        // Lấy thông tin lỗi chi tiết từ BindingResult
        StringBuilder errorMessage = new StringBuilder("Validation errors: ");
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldError = ((org.springframework.validation.FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            errorMessage.append(String.format("[%s: %s] ", fieldError, defaultMessage));
        });

        // Set thông báo lỗi vào ApiResponse
        response.setMessage(errorMessage.toString().trim());
        response.setCode(400); // Validation lỗi => HTTP 400 (Bad Request)

        // Trả về response với HTTP 400
        return ResponseEntity.badRequest().body(response);
    }

/*
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException e){
        ErrorCode errorCode = e.getStatusCode();

        ApiResponse response = new ApiResponse();
        response.setMessage(errorCode.getMessage());
        response.setCode(errorCode.getCode());

        return ResponseEntity.badRequest().body(response);

    }*/

}
