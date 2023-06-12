package com.learning.BankingApplication.stringToEnumConverter;

import com.learning.BankingApplication.entity.Approved;
import com.learning.BankingApplication.entity.ERole;
import org.springframework.core.convert.converter.Converter;

public class StringToApprovedConverter implements Converter<String, Approved> {
    @Override
    public Approved convert(String source) {
        try {
            return Approved.valueOf(source);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("input not match the ERole enum");
        }
    }


}