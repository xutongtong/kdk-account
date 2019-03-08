package com.kaidike.account.domain.model.sns;

public class Wechat {
    private String appid;

    private String appSecret;

    public Wechat(String appid, String appSecret) {
        this.appid = appid;
        this.appSecret = appSecret;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
