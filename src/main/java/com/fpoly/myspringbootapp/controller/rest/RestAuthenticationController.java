package com.fpoly.myspringbootapp.controller.rest;

import com.fpoly.myspringbootapp.dto.request.AuthenticationRequest;
import com.fpoly.myspringbootapp.dto.request.IntrospectRequest;
import com.fpoly.myspringbootapp.dto.response.ApiResponse;
import com.fpoly.myspringbootapp.dto.response.AuthenticationResponse;
import com.fpoly.myspringbootapp.dto.response.IntrospectResponse;
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
}
