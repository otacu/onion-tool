package com.egoist.oniontool.common.util;

import java.security.MessageDigest;

public final class MD5Util {
    private MD5Util() {
    }

    /**
     * MD5加密
     *
     * @param s 原文字符串
     * @return String 密文字符串
     */
    public static String string2MD5(String s) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for (int i = 0; i < j; ++i) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            return (new String(str)).toLowerCase();
        } catch (Exception var10) {
            var10.printStackTrace();
            return null;
        }
    }
}
