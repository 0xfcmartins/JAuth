package com.java.jauth.resources;

import com.java.jauth.api.dto.requests.RegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("auth")
public interface IJAuth {

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    ResponseEntity<Object> register(@RequestBody RegisterDTO request);

    @PostMapping(path = "/doLogin", consumes = "application/json", produces = "application/json")
    ResponseEntity<Object> doLogin(@RequestBody Object request);

}
