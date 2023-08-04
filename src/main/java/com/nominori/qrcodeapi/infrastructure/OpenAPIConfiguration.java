package com.nominori.qrcodeapi.infrastructure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "QR / Barcode API",
                description = "Simple to use REST API for generating QR codes and EAN8/13 Barcodes.",
                contact = @Contact(
                        name = "nominori-dev",
                        url = "https://github.com/nominori-dev",
                        email = "nominori@bdv.pw"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://github.com/nominori-dev/qrcode-api/LICENSE"
                )
        )
)
public class OpenAPIConfiguration {
}
