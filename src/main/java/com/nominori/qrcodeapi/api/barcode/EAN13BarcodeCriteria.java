package com.nominori.qrcodeapi.api.barcode;

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
    private Integer width = 300;

    @Min(50)
    @Max(500)
    private Integer height = 150;

}
