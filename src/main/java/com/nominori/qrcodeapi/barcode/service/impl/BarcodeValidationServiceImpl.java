package com.nominori.qrcodeapi.barcode.service.impl;

import com.nominori.qrcodeapi.barcode.service.BarcodeValidationService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class BarcodeValidationServiceImpl implements BarcodeValidationService {

    private static final Pattern EAN_13_PATTERN = Pattern.compile("^(?!0{12})\\d{12}$");

    @Override
    public Boolean validateEAN13Barcode(String data) {
        return EAN_13_PATTERN.matcher(data).matches();
    }
}
