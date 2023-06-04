package com.learning.BankingApplication.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterReponse {
    private long id;
    private String username;
    private String fullname;
    private String password;


}
