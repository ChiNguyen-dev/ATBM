package com.Tool.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public String encrypt(String srcText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String enrText;
        MessageDigest msd = MessageDigest.getInstance("MD5");
        byte[] srcTextBytes = srcText.getBytes("UTF-8");
        byte[] enrTextBytes = msd.digest(srcTextBytes);

        BigInteger bigInt = new BigInteger(1, enrTextBytes);
        enrText = bigInt.toString(16);

        return enrText;
    }



    public static String getMD5(File file) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            FileInputStream fis = new FileInputStream(file);
            byte[] dataBytes = new byte[1024];
            int nread = 0;
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
            byte[] byteData = md.digest();
            fis.close();
            return convertByteToHex(byteData);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String convertByteToHex(byte[] data) {
        BigInteger number = new BigInteger(1, data);
        String hashtext = number.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;

    }
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MD5 md5 = new MD5();
        String srcText = "DAI HOC NONG LAM";
        String enrText = md5.encrypt(srcText);
        System.out.println(enrText);

    }

}
