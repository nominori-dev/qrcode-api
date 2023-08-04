package com.nominori.qrcodeapi.api.barcode;

import com.nominori.qrcodeapi.application.barcode.BarcodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
@Tag(name = "barcode", description = "The Barcode API")
public class BarcodeController {

    private final BarcodeService barcodeService;

    @Operation(summary = "Generate EAN13 Barcode from provided input data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Barcode generated"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or data supplied")
    })
    @GetMapping(value = "/ean13/{data}", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage getEAN13Barcode(@PathVariable @Valid @NotBlank @Size(max = 13) String data, @Valid EAN13BarcodeCriteria ean13BarcodeCriteria){
        return barcodeService.generateEAN13BarcodeImage(data, ean13BarcodeCriteria.getWidth(), ean13BarcodeCriteria.getHeight());
    }




}
