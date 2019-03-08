package com.kaidike.account.domain.service.account;

import com.kaidike.account.domain.utils.KDKNumber;
import com.kaidike.account.domain.utils.MD5;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    public Map<String, String> encryptPassword(String password) {
        int lenth = 4;
        String salt = "" + KDKNumber.random(lenth);

        MD5 md5 = new MD5();
        String encryptedPassword = md5.hash(md5.hash(password) + salt);

        Map<String, String> map = new HashMap<String, String>();

        map.put("salt", salt);
        map.put("password", encryptedPassword);

        return map;
    }

}
