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
        return Base64.getEncoder().encodeToString(cipherByte);
    }

    public String decrypt(String cipherbyte) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if (publicKey == null)
            return null;
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(cipherbyte)));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        RSA rsa = new RSA();
        rsa.createKey();
        String hashcode = "e6dba466557a3fb4e54ea2bbe96d1ad7";
        System.out.println(rsa.encrypt(hashcode));

    }
}
