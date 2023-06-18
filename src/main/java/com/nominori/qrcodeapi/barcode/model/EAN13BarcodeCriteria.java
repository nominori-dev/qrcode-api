package com.nominori.qrcodeapi.barcode.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EAN13BarcodeCriteria {

    @Min(100)
    @Max(1000)
    private Integer width;

    @Min(50)
    @Max(500)
    private Integer height;

}
