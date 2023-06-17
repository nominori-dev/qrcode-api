package com.nominori.qrcodeapi.barcode.controller;

import com.nominori.qrcodeapi.barcode.service.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcode")
@RequiredArgsConstructor
public class BarcodeController {

    private final BarcodeService barcodeService;

    @GetMapping(value = "/ean13/{data}", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage getEAN13Barcode(@PathVariable String data, @RequestParam(defaultValue = "300") Integer width, @RequestParam(defaultValue = "150") Integer height){
        return barcodeService.generateEAN13BarcodeImage(data, width, height);
    }




}
