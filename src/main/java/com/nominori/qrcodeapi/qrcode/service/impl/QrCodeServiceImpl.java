package com.nominori.qrcodeapi.qrcode.service.impl;

import com.nominori.qrcodeapi.qrcode.service.QrCodeService;
import net.glxn.qrgen.core.exception.QRGenerationException;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class QrCodeServiceImpl implements QrCodeService {
    @Override
    public BufferedImage generate(String data, Integer height, Integer width) {
        ByteArrayOutputStream stream = QRCode.from(data)
                .withSize(width, height).stream();

        InputStream inputStream = new ByteArrayInputStream(stream.toByteArray());
        try {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new QRGenerationException("An error occurred while processing output image.", e);
        }
    }

}
