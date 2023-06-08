package com.learning.BankingApplication.stringToEnumConverter;

import com.learning.BankingApplication.entity.Status;
import com.learning.BankingApplication.entity.TransactionType;
import org.springframework.core.convert.converter.Converter;

public class StringToTransactionTypeConverter implements Converter<String, TransactionType> {
    @Override
    public TransactionType convert(String source) {
        try {
            return TransactionType.valueOf(source);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("input not match the TransactionType enum");
        }
    }


}