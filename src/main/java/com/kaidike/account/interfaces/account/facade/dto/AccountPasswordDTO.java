package com.kaidike.account.interfaces.account.facade.dto;

import java.io.Serializable;

public final class AccountPasswordDTO implements Serializable {

    private final String countryCode;
    private final String mobile;
    private final String password;

    public AccountPasswordDTO(String countryCode, String mobile, String password) {
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.password = password;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }
}
