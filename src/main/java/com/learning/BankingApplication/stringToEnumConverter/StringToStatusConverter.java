package com.learning.BankingApplication.stringToEnumConverter;

import com.learning.BankingApplication.entity.Status;
import org.springframework.core.convert.converter.Converter;

public class StringToStatusConverter implements Converter<String, Status> {
    @Override
    public Status convert(String source) {
        try {
            return Status.valueOf(source);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("input not match the Status enum");
        }
    }


}
