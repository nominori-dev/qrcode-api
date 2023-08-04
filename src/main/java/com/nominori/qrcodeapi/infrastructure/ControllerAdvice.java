package com.nominori.qrcodeapi.infrastructure;

import com.nominori.qrcodeapi.infrastructure.dto.ErrorResponse;
import com.nominori.qrcodeapi.infrastructure.exception.BarcodeWriterException;
import com.nominori.qrcodeapi.infrastructure.exception.InvalidChecksumException;
import jakarta.validation.ConstraintViolationException;
import net.glxn.qrgen.core.exception.QRGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleConstraintViolationException(ConstraintViolationException exception){

        Map<String, String> errors = new HashMap<>();
        exception.getConstraintViolations().forEach((constraintViolation -> {
            String errorMessage = constraintViolation.getMessage();
            errors.put("invalid query param", errorMessage);
        }));

        return errors;
    }

    @ExceptionHandler(value = {QRGenerationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleQRGenerationException(QRGenerationException e){
        return new ErrorResponse(e.getMessage());
    }

}
