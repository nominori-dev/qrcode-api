package com.nominori.qrcodeapi.core.exception;

public class InvalidChecksumException extends RuntimeException{
    public InvalidChecksumException(String message) {
        super(message);
    }
}
