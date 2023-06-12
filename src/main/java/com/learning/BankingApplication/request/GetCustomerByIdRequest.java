package com.learning.BankingApplication.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class GetCustomerByIdRequest {
    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d+$")
    private long id;

	public GetCustomerByIdRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetCustomerByIdRequest(@NotNull @NotBlank @Pattern(regexp = "^\\d+$") long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GetCustomerByIdRequest [id=" + id + "]";
	}
    
}
