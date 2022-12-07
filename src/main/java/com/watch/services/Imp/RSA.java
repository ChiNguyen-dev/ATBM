package com.watch.services.Imp;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
    KeyPair keypair;
    public PublicKey publicKey;
    public PrivateKey privateKey;

    public void createKey() throws NoSuchAlgorithmException {
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        kg.initialize(1204);
        keypair = kg.generateKeyPair();
        publicKey = keypair.getPublic();
        privateKey = keypair.getPrivate();
    }

    public String encrypt(String text) throws NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        byte[] byteText = text.getBytes();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherByte = cipher.doFinal(byteText);
        return new String(cipherByte);
    }

    public String decrypt(String cipherbyte) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if (publicKey == null)
            return null;
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(cipherbyte)));
    }

    public static void main(String[] args) {
//        RSA rsa = new RSA();
//        byte[] byteKey = Base64.getDecoder().decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDG05BaDdqWDLFPjQUD+hbidCuirb4Z8wwxsJadlFVtvf1hkrY27X0HPWu7SEy6aoFdfPnVqtK3+tS1Kbf3WnyvSr9kM1Hnm/NPXE2Y8/dsWl6eVFg/o+JqBSkT9MsNfig6o6465936iLP/YkPE0l6y7ookBO1OGhPmukacxdQrZQIDAQAB");
//        X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
//        PublicKey pubKey;
//        try {
//            KeyFactory kf = KeyFactory.getInstance("RSA");
//            pubKey = kf.generatePublic(X509publicKey);
//            rsa.publicKey = pubKey;
//            rsa.decrypt(("DskGp+71dEPzPbGjLDsriASEnvyW8LebOpwuGz+BRW+wffgTf+3n1FU" +
//                    "c6XWSU382fB4+7b0eM+8py0MvyddyblIIeklkuS3q+XQ6y/hjU2OxbWfdkBlk2NUoQlk+euqESNs29GMglKng" +
//                    "PHigSVJzgJvVuuS7w1JD3aV5kD6LetU="));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }
}
