package com.kaidike.account.domain.model.session;

public class KDKSession {

    private String token;

    private String value;

    public KDKSession() {

    }

    public KDKSession(String token, String value) {
        this.token = token;
        this.value = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
