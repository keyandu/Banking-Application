package com.learning.BankingApplication.stringToEnumConverter;

import com.learning.BankingApplication.entity.AccountType;
import com.learning.BankingApplication.entity.ERole;
import org.springframework.core.convert.converter.Converter;

public class StringToAccountTypeConverter implements Converter<String, AccountType> {
    @Override
    public AccountType convert(String source) {
        try {
            return AccountType.valueOf(source);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("input not match the AccountType enum");
        }
    }
}
