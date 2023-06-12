package com.learning.BankingApplication.stringToEnumConverter;

import com.learning.BankingApplication.entity.ERole;
import org.springframework.core.convert.converter.Converter;

public class StringToERoleConverter implements Converter<String, ERole>  {
    @Override
    public ERole convert(String source) {
        try {
            return ERole.valueOf(source);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("input not match the ERole enum");
        }
    }


}