package com.java.jauth.facade;

import com.java.jauth.api.dto.requests.RegisterDTO;
import com.java.jauth.api.dto.responses.RegisterResponseDTO;
import com.java.jauth.dao.RegisterDAO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegisterFacade {

    @Resource
    RegisterDAO dao;

    private void hashPassword(RegisterDTO request) throws NoSuchAlgorithmException {
        MessageDigest encoder = MessageDigest.getInstance("MD5");
        encoder.update(request.password.getBytes(), 0, request.password.length());
        request.password = new BigInteger(1, encoder.digest()).toString(16);
    }

    public RegisterResponseDTO register(RegisterDTO request) {
        try {
            this.hashPassword(request);

            return dao.register(request);
        } catch (NoSuchAlgorithmException e) {

            return new RegisterResponseDTO(false, e.getMessage());
        }
    }

}
