package com.kaidike.account.interfaces.account.facade.dto;

public class AccountPasswordForgotDTO {

    private final String countryCode;

    private final String mobile;

    private final String smsCode;

    private final String password;

    private final String confirmPassword;

    public AccountPasswordForgotDTO(String countryCode, String mobile, String smsCode, String password, String confirmPassword) {
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.smsCode = smsCode;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getMobile() {
        return mobile;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
