package com.fpoly.myspringbootapp.exception.controller;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExceptionController {



    // Xử lý lỗi 404 (Not Found)
    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(NoResourceFoundException e) {
        e.printStackTrace();
        return "exception/notfound"; // Trả về trang không tìm thấy tài nguyên
    }

    // Xử lý lỗi 500 (Internal Server Error)
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Đặt mã trạng thái HTTP là 500
//    public String handleInternalServerError(Exception e) {
//        e.printStackTrace();
//        return "exception/exception"; // Trả về trang lỗi 500
//    }

    @ExceptionHandler(NullPointerException.class)
    public String exceptionNull(NullPointerException e){
        e.printStackTrace();

        return "exception/exception";
    }




}
