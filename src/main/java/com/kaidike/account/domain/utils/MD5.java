package com.kaidike.account.domain.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public String hash(String s) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();
            messageDigest.update(s.getBytes(Charset.forName("UTF8")));

            byte[] digest = messageDigest.digest();

            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; ++i) {
                stringBuffer.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1, 3));
            }

            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {

        }

        return null;
    }

}
