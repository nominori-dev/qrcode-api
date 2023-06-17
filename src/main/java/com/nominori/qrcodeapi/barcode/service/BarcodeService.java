package com.nominori.qrcodeapi.barcode.service;

import java.awt.image.BufferedImage;

public interface BarcodeService {
    BufferedImage generateEAN13BarcodeImage(String data, Integer width, Integer height);

}
