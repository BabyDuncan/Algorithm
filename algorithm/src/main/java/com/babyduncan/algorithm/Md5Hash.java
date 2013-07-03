package com.babyduncan.algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用md5 的散列方式获取哈希值
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-3 15:58
 */
public class Md5Hash {

    public static void main(String... args) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        md5.update("babyduncan".getBytes());
        byte[] result = md5.digest();
        char str[] = new char[16 * 2];
        int k = 0;
        for (int i = 0; i < 16; i++) {
            byte byte0 = result[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        String s = new String(str);
        System.out.println(s);
    }

}
