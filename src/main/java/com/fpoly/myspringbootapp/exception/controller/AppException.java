package com.fpoly.myspringbootapp.exception.controller;

import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AppException extends RuntimeException{

    private ErrorCodeException errorCode;

    public AppException(ErrorCodeException errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
