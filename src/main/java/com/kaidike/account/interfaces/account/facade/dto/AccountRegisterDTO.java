package com.kaidike.account.interfaces.account.facade.dto;

import java.io.Serializable;

public class AccountRegisterDTO implements Serializable {

    private String countryCode;

    private String mobile;

    private String smsCode;

    private String password;

    private String confirmPassword;

    public AccountRegisterDTO(String countryCode, String mobile, String smsCode, String password, String confirmPassword) {
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.smsCode = smsCode;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
