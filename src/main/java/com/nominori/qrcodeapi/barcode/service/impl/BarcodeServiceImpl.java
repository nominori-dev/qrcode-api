package com.nominori.qrcodeapi.barcode.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.nominori.qrcodeapi.barcode.service.BarcodeService;
import com.nominori.qrcodeapi.barcode.service.BarcodeValidationService;
import com.nominori.qrcodeapi.barcode.service.ChecksumService;
import com.nominori.qrcodeapi.core.exception.BarcodeWriterException;
import com.nominori.qrcodeapi.core.exception.InvalidChecksumException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
@RequiredArgsConstructor
public class BarcodeServiceImpl implements BarcodeService {

    private final BarcodeValidationService barcodeValidationService;
    private final ChecksumService checksumService;

    @Override
    public BufferedImage generateEAN13BarcodeImage(String data, Integer width, Integer height) {
        if (!barcodeValidationService.validateEAN13Barcode(data)) {
            throw new BarcodeWriterException("Provided input data is not supported by EAN-13 Standard.");
        }

        try {
            String processedData = data + checksumService.getEAN13Checksum(data);
            EAN13Writer barcodeWriter = new EAN13Writer();
            BitMatrix bitMatrix = barcodeWriter.encode(processedData, BarcodeFormat.EAN_13, width, height);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new BarcodeWriterException("Something went wrong while generating barcode image. Please try later.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new InvalidChecksumException("Failed generating checksum for provided data");
        }
    }
}
