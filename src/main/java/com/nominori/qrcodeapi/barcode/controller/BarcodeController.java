package com.nominori.qrcodeapi.barcode.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcode")
public class BarcodeController {

    @GetMapping("/{data}")
    public Mono<BufferedImage> getBarcode(@PathVariable String data){
        return null;
    }




}
