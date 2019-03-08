package com.kaidike.account.domain.model.sns;

public class WechatUser {

    private String openid;

    private String unionID;

    private String nickname;

    private String avatar;

    private String sex;

    private String country;

    private String province;

    private String city;

    public WechatUser(String openid, String unionID, String nickname, String avatar, String sex, String country, String province, String city) {
        this.openid = openid;
        this.unionID = unionID;
        this.nickname = nickname;
        this.avatar = avatar;
        this.sex = sex;
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionID() {
        return unionID;
    }

    public void setUnionID(String unionID) {
        this.unionID = unionID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
