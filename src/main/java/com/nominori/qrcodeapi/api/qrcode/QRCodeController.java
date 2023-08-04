package com.nominori.qrcodeapi.api.qrcode;

import com.nominori.qrcodeapi.application.qrcode.QrCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "qr-code", description = "The QR Code API")
public class QRCodeController {

    private final QrCodeService qrCodeService;

    @Operation(summary = "Generate QR Code from provided input data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "QR Code generated"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or data supplied")
    })
    @GetMapping(value = "/{data}", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage getQrCode(@PathVariable @Valid  @Size(max = 4296) String data, @Valid QrCodeCriteria criteria){
        return qrCodeService.generate(data, criteria.getHeight(), criteria.getWidth());
    }

}
