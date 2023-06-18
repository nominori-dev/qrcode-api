package com.nominori.qrcodeapi.qrcode.service;

import java.awt.image.BufferedImage;

public interface QrCodeService {
    BufferedImage generate(String data, Integer height, Integer width);
}
