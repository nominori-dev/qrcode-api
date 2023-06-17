package com.nominori.qrcodeapi.barcode.service.impl;

import com.nominori.qrcodeapi.barcode.service.ChecksumService;
import com.nominori.qrcodeapi.core.exception.InvalidChecksumException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class ChecksumServiceImpl implements ChecksumService {
    @Override
    public String getEAN13Checksum(String data) {
        try {
            int[] array = Stream.of(data.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int oddSum = 0;
            int evenSum = 0;

            for(int i = 0; i < array.length; i++){
                if(i % 2 == 0){
                    oddSum += array[i];
                }else{
                    evenSum += array[i];
                }
            }

            int result = (evenSum * 3 + oddSum) % 10;
            if(result > 0){
                result = 10 - result;
            }

            return String.valueOf(result);
        }catch (Exception exception) {
            throw new InvalidChecksumException("An error occupied while generating checksum.");
        }
    }
}
