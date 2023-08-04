package com.nominori.qrcodeapi.application.barcode;

public interface BarcodeValidationService {
    Boolean validateEAN13Barcode(String data);
}
