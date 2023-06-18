package com.nominori.qrcodeapi.qrcode.model;

import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class QrCodeCriteria {

    @Max(1000)
    private Integer width = 250;

    @Max(1000)
    private Integer height = 250;

}
