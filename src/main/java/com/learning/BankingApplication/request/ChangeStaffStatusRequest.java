package com.learning.BankingApplication.request;

import com.learning.BankingApplication.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeStaffStatusRequest {
    @NotNull
    @NotBlank
    private long staffId;
    @NotNull
    @NotBlank
    @Pattern(regexp = "Enable|Disable",message = "should enter Enable or Disable")
    private Status status;
}
