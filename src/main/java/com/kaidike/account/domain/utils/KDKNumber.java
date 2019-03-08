package com.kaidike.account.domain.utils;

import java.util.Random;

public class KDKNumber {

    public static String randomStr(int length) {
        return "" + random(length);
    }

    public static int random(int length) {
        Random rnd = new Random();
        int baseValue = (int)Math.pow(10, length);

        int random = baseValue + rnd.nextInt(900000);

        return random;
    }

}
