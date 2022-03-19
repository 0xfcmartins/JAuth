package com.java.jauth.api.dto.responses;

public class RegisterResponseDTO {

    public Integer id;
    public boolean success;
    public String message;

    public RegisterResponseDTO() {
    }

    public RegisterResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public RegisterResponseDTO(Integer id, String message) {
        this.id = id;
        this.success = true;
        this.message = message;
    }
}
