package com.kaidike.account.domain.model.account;

import com.kaidike.account.domain.utils.MD5;

public class Account {

    private Long id;

    private String countryCode;

    private String mobile;

    private String password;

    private String salt;

    private String unionID; // 微信用户

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUnionID() {
        return unionID;
    }

    public void setUnionID(String unionID) {
        this.unionID = unionID;
    }

    public boolean isPasswordEqual(String password) {
        String encryptedPassword = this.encryptPassword(password);

        if (encryptedPassword == this.password) {
            return true;
        }

        return false;
    }

    public String encryptPassword(String password) {
        MD5 md5 = new MD5();

        String md5Password = md5.hash(password);
        String encryptedPassword = md5.hash(md5Password + this.salt);

        return encryptedPassword;
    }
}
