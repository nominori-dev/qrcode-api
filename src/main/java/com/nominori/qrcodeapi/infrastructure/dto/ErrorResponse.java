package com.nominori.qrcodeapi.infrastructure.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ErrorResponse {

    private String message;
    private String currentData;

    public ErrorResponse(String message) {
        this.message = message;
        this.currentData = Instant.now().toString();
    }
}
