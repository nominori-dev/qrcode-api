package com.nominori.qrcodeapi.core;

import com.nominori.qrcodeapi.core.dto.ErrorResponse;
import com.nominori.qrcodeapi.core.exception.BarcodeWriterException;
import com.nominori.qrcodeapi.core.exception.InvalidChecksumException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BarcodeWriterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBarcodeWriterException(BarcodeWriterException e){
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(value = {InvalidChecksumException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidChecksumException(InvalidChecksumException e){
        return new ErrorResponse(e.getMessage());
    }

}
