package com.nominori.qrcodeapi.application.barcode;

public interface ChecksumService {
    String getEAN13Checksum(String data);
}
