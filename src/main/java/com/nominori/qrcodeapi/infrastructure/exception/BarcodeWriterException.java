package com.nominori.qrcodeapi.infrastructure.exception;

public class BarcodeWriterException extends RuntimeException{
    public BarcodeWriterException(String message) {
        super(message);
    }
}
