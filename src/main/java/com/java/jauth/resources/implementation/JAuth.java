package com.java.jauth.resources.implementation;

import com.java.jauth.api.dto.requests.RegisterDTO;
import com.java.jauth.facade.AuthenticationFacade;
import com.java.jauth.facade.RegisterFacade;
import com.java.jauth.resources.IJAuth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class JAuth implements IJAuth {

    @Resource
    RegisterFacade register;

    @Resource
    AuthenticationFacade authenticator;

    @Override
    public ResponseEntity<Object> register(RegisterDTO request) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(register.register(request));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @Override
    public ResponseEntity<Object> doLogin(Object request) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(authenticator.doLogin(request));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

}
