package com.nominori.qrcodeapi.infrastructure.exception;

public class InvalidChecksumException extends RuntimeException{
    public InvalidChecksumException(String message) {
        super(message);
    }
}
