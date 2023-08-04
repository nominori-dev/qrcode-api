package com.nominori.qrcodeapi.application.qrcode;

import java.awt.image.BufferedImage;

public interface QrCodeService {
    BufferedImage generate(String data, Integer height, Integer width);
}
