package com.fpoly.myspringbootapp.controller.rest;

import com.fpoly.myspringbootapp.dto.request.AuthenticationRequest;
import com.fpoly.myspringbootapp.dto.request.IntrospectRequest;
import com.fpoly.myspringbootapp.dto.request.LogoutRequest;
import com.fpoly.myspringbootapp.dto.request.RefreshRequest;
import com.fpoly.myspringbootapp.dto.response.ApiResponse;
import com.fpoly.myspringbootapp.dto.response.AuthenticationResponse;
import com.fpoly.myspringbootapp.dto.response.IntrospectResponse;
import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import com.fpoly.myspringbootapp.service.impl.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestAuthenticationController {


    AuthenticationService service;

    @PostMapping("/token")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> generateToken(@RequestBody AuthenticationRequest request) {

        ApiResponse<AuthenticationResponse> response = new ApiResponse<>();
        var result = service.authenticationUser(request);
        response.setResult(result);
        response.setCode(200);


        return ResponseEntity.ok(response);

    }

    @PostMapping("/introspect")
    public ResponseEntity<ApiResponse<IntrospectResponse>> authenticated(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {

        ApiResponse<IntrospectResponse> response = new ApiResponse<>();
        IntrospectResponse result = service.introspect(request);
        response.setResult(result);
        response.setCode(1000);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        service.logoutToken(request);
        return ApiResponse.<Void>builder()
                .code(ErrorCodeException.SUCCESS_CODE.getCode())
                .build();
    }


    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> refreshToken(@RequestBody RefreshRequest request) throws ParseException, JOSEException {

        ApiResponse<AuthenticationResponse> response = new ApiResponse<>();
        var result = service.refreshToken(request);
        response.setResult(result);
        response.setCode(ErrorCodeException.SUCCESS_CODE.getCode());
        return ResponseEntity.ok(response);

    }
}
