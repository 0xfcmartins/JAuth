package com.java.jauth.dao;

import com.java.jauth.api.dto.requests.RegisterDTO;
import com.java.jauth.api.dto.responses.RegisterResponseDTO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegisterDAO {

    public RegisterResponseDTO register(RegisterDTO request) {
        //"Do the database insert"

        return new RegisterResponseDTO(1, "User " + request.username + ", registered with success!");
    }
}
