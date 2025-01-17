package com.fpoly.myspringbootapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCodeException {
    SUCCESS_CODE(1000, "Success fully!", HttpStatus.OK),
    ERROR_CODE(500, "Error ,please try again!",HttpStatus.INTERNAL_SERVER_ERROR),
    PROVINCE_NAME_EXISTS(1001, "The province already exists!",HttpStatus.BAD_REQUEST),
    DISTRICT_NAME_EXISTS(1002, "The district already exists!",HttpStatus.BAD_REQUEST),
    COMMUNE_NAME_EXISTS(1003, "The commune already exists!",HttpStatus.BAD_REQUEST),
    PROVINCE_NOT_FOUND(404, "The province not found!",HttpStatus.NOT_FOUND),
    USER_NOT_EXITS(404, "The user not found!",HttpStatus.NOT_FOUND),
    USER_READY_EXITS(1008, "The user already exits!",HttpStatus.BAD_REQUEST),
    ROLE_NOT_EXITS(404, "The role not found!",HttpStatus.NOT_FOUND),
    PERMISSION_NOT_EXITS(404, "The permission not found!",HttpStatus.NOT_FOUND),
    DISTRICT_NOT_FOUND(404, "The district not found!",HttpStatus.NOT_FOUND),
    CERTIFICATE_NOT_FOUND(404, "The certificate not found!",HttpStatus.NOT_FOUND),
    COMMUNE_NOT_FOUND(404, "The commune not found!",HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1005,"Unauthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1006,"You do not have permission",HttpStatus.FORBIDDEN),
    USERNAME_NOT_NULL(1009,"Please into username",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1010,"Password invalid",HttpStatus.BAD_REQUEST),
    INVALID_AGE(1007,"Invalid age",HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatusCode statusCode;

}
