package com.kaidike.account.interfaces.account.facade.dto;

import java.io.Serializable;

public final class AccountSMSCodeDTO implements Serializable {

    private final String countryCode;
    private final String mobile;
    private final String smsCode;

    public AccountSMSCodeDTO(String countryCode, String mobile, String smsCode) {
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.smsCode = smsCode;
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
}
