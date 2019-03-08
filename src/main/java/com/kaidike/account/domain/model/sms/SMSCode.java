package com.kaidike.account.domain.model.sms;

import java.util.Date;

public class SMSCode {
    private Long id;
    private String countryCode;
    private String mobile;
    private String code;
    private Long sendTime;
    private Long expiredTime;

    public SMSCode(String countryCode, String mobile, String code) {
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.code = code;
    }

    public boolean isExpired() {
        Long currentTime = new Date().getTime();

        if (currentTime < expiredTime) {
            return true;
        }

        return false;
    }

    public boolean isEqual(String code) {
        if ( !code.isEmpty() && code == this.code) {
            return true;
        }

        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }
}
