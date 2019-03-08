package com.kaidike.account.interfaces.account.facade.dto;

public class AccountWechatDTO {

    final String nickname;

    final String avatar;

    final String sex;

    final String country;

    final String province;

    final String city;

    final String openid;

    final String unionID;

    public AccountWechatDTO(String nickname, String avatar, String sex, String country, String province, String city, String openid, String unionID) {
        this.nickname = nickname;
        this.avatar = avatar;
        this.sex = sex;
        this.country = country;
        this.province = province;
        this.city = city;
        this.openid = openid;
        this.unionID = unionID;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getOpenid() {
        return openid;
    }

    public String getUnionID() {
        return unionID;
    }
}
