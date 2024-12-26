package com.fpoly.myspringbootapp.service.impl;

import com.fpoly.myspringbootapp.dto.request.AuthenticationRequest;
import com.fpoly.myspringbootapp.dto.request.IntrospectRequest;
import com.fpoly.myspringbootapp.dto.response.AuthenticationResponse;
import com.fpoly.myspringbootapp.dto.response.IntrospectResponse;
import com.fpoly.myspringbootapp.entity.Role;
import com.fpoly.myspringbootapp.entity.UserEntity;
import com.fpoly.myspringbootapp.exception.controller.AppException;
import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import com.fpoly.myspringbootapp.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {


    UserRepository repository;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;


    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {


        var token = request.getToken();

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        var verified = signedJWT.verify(verifier) && !expiryTime.before(new Date());
        return IntrospectResponse.builder()
                .valid(verified)
                .build();
    }


    public AuthenticationResponse authenticationUser(AuthenticationRequest request) {

        UserEntity user = repository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!authenticated) {
            throw new AppException(ErrorCodeException.UNAUTHENTICATED);
        }

        var token = generateToken(user);

        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(token)
                .isAuthenticated(true)
                .build();
        return authenticationResponse;

    }


    private String generateToken(UserEntity user) {


        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issuer("Devteria.com")
                .issueTime(new Date())
                .expirationTime(
                        Date.from(Instant.now().plus(1, ChronoUnit.HOURS))
                )
                .claim("scope", buildScope(user))
                .build();


        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


    private String buildScope(UserEntity user) {

        StringJoiner stringJoiner = new StringJoiner(" ");

        if (!CollectionUtils.isEmpty(user.getRoles())) {
            user.getRoles().forEach(role -> {
                stringJoiner.add("ROLE_" + role.getName());
                if (!CollectionUtils.isEmpty(role.getPermissions())) {
                    role.getPermissions()
                            .forEach(permission -> {
                                stringJoiner.add(permission.getName());
                            });
                }
            });
        }

        return stringJoiner.toString();

    }


}
