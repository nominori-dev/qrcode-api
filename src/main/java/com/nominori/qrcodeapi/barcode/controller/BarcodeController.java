package com.nominori.qrcodeapi.barcode.controller;

import com.nominori.qrcodeapi.barcode.model.EAN13BarcodeCriteria;
import com.nominori.qrcodeapi.barcode.service.BarcodeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcode")
@RequiredArgsConstructor
@Validated
public class BarcodeController {

    private final BarcodeService barcodeService;

    @GetMapping(value = "/ean13/{data}", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage getEAN13Barcode(@PathVariable @Size(max = 13) String data, @Valid EAN13BarcodeCriteria ean13BarcodeCriteria){
        return barcodeService.generateEAN13BarcodeImage(data, ean13BarcodeCriteria.getWidth(), ean13BarcodeCriteria.getHeight());
    }




}
