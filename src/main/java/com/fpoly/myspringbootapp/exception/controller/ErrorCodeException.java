package com.fpoly.myspringbootapp.exception.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCodeException {
    SUCCESS_CODE(1000, "Success fully!"),
    ERROR_CODE(500, "Error ,please try again!"),
    PROVINCE_NAME_EXISTS(1001, "The province already exists!"),
    DISTRICT_NAME_EXISTS(1002, "The district already exists!"),
    COMMUNE_NAME_EXISTS(1003, "The commune already exists!"),
    PROVINCE_NOT_FOUND(404, "The province not found!"),
    DISTRICT_NOT_FOUND(404, "The district not found!"),
    CERTIFICATE_NOT_FOUND(404, "The certificate not found!"),
    COMMUNE_NOT_FOUND(404, "The commune not found!"),
    UNAUTHENTICATED(1005,"Unauthenticated");

    private int code;
    private String message;

}
