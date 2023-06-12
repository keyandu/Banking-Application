package com.learning.BankingApplication.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotNull(message = "username shouldn't be null")
    private String userName;
    @NotBlank
    @NotNull
    private String fullName;
    @Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",message = "pass")
    private String password;
	public UserRegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegisterRequest(@NotNull(message = "username shouldn't be null") String userName,
			@NotBlank @NotNull String fullName,
			@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "pass") String password) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserRegisterRequest [userName=" + userName + ", fullName=" + fullName + ", password=" + password + "]";
	}



}
