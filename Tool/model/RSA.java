package com.Tool.model;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSA {

    public static PrivateKey getPrivateKey() throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(GenerateKeyRSA.PRIVATE_KEY_FILE).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public static PublicKey getPublicKey() throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(GenerateKeyRSA.PUBLIC_KEY_FILE).toPath());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public String encrypt(String plainText) throws Exception {
        byte[] arrText = plainText.getBytes();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.getPublicKey());
        byte[] encryptBytes = cipher.doFinal(arrText);
        return encode(encryptBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public String decrypt(String enText) throws Exception {
        byte[] encryptByte = decode(enText);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.getPrivateKey());
        byte[] decryptEnText = cipher.doFinal(encryptByte);
        return new String(decryptEnText, "UTF8");

    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();
        String textPlain = "daihocnonglam";
        try {
            System.out.println(rsa.encrypt(textPlain));
            System.out.println(rsa.decrypt(rsa.encrypt(textPlain)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
