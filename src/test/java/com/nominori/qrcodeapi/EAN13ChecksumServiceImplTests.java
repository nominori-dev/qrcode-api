package com.nominori.qrcodeapi;

import com.nominori.qrcodeapi.application.barcode.ChecksumService;
import com.nominori.qrcodeapi.application.barcode.impl.ChecksumServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EAN13ChecksumServiceImplTests {

    private ChecksumService checksumService;

    @BeforeEach
    void initChecksumService(){
        checksumService = new ChecksumServiceImpl();
    }

    @Test
    void generatedEAN13ChecksumIsValid(){
        String inputValue = "215000000001";
        String validChecksum = "7";

        assertThat(checksumService.getEAN13Checksum(inputValue)).isEqualTo(validChecksum);

        inputValue = "978020137962";
        validChecksum = "4";

        assertThat(checksumService.getEAN13Checksum(inputValue)).isEqualTo(validChecksum);

        inputValue = "9780521425575";
        validChecksum = "0";

        assertThat(checksumService.getEAN13Checksum(inputValue)).isEqualTo(validChecksum);
    }

}
