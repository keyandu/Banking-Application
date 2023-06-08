package com.learning.BankingApplication.stringToEnumConverter;

import com.learning.BankingApplication.entity.BeneficiaryActive;
import com.learning.BankingApplication.entity.ERole;
import org.springframework.core.convert.converter.Converter;

public class StringToBeneficiaryActiveConverter implements Converter<String, BeneficiaryActive> {
    @Override
    public BeneficiaryActive convert(String source) {
        try {
            return BeneficiaryActive.valueOf(source);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("input not match the BeneficiaryActive enum");
        }
    }
}
