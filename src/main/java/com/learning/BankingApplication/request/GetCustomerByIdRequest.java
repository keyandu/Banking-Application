package com.learning.BankingApplication.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;





@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerByIdRequest {
    @NotNull
    @Pattern(regexp = "^\\d+$")
    private Long id;
}
