package com.nominori.qrcodeapi.qrcode.controller;

import com.nominori.qrcodeapi.qrcode.model.QrCodeCriteria;
import com.nominori.qrcodeapi.qrcode.service.QrCodeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/qr-code")
@Validated
@RequiredArgsConstructor
public class QRCodeController {

    private final QrCodeService qrCodeService;

    @GetMapping(value = "/{data}", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage getQrCode(@PathVariable @Valid  @Size(max = 4296) String data, @Valid QrCodeCriteria criteria){
        return qrCodeService.generate(data, criteria.getHeight(), criteria.getWidth());
    }

}
