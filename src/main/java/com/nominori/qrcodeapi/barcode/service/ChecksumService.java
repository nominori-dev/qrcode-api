package com.nominori.qrcodeapi.barcode.service;

public interface ChecksumService {
    String getEAN13Checksum(String data);
}
