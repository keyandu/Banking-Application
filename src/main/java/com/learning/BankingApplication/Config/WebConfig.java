package com.learning.BankingApplication.Config;

import com.learning.BankingApplication.stringToEnumConverter.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToStatusConverter());
        registry.addConverter(new StringToAccountTypeConverter());
        registry.addConverter(new StringToTransactionTypeConverter());
        registry.addConverter(new StringToERoleConverter());
        registry.addConverter(new StringToBeneficiaryActiveConverter());
        registry.addConverter(new StringToApprovedConverter());
    }
}
