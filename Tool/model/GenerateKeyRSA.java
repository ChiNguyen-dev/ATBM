package com.Tool.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class GenerateKeyRSA {
    public static final String PUBLIC_KEY_FILE = "rsa_keypair/publickey";
    public static final String PRIVATE_KEY_FILE = "rsa_keypair/privatekey";

    private KeyPairGenerator keyGen;
    private KeyPair keyPair;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public GenerateKeyRSA(int lenght) throws NoSuchAlgorithmException {
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(lenght);
    }

    public void createKey() {
        this.keyPair = this.keyGen.generateKeyPair();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void writeToFile(String path, byte[] key) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public void generateKeyToFile() {
        try {
            this.createKey();
            this.writeToFile(PUBLIC_KEY_FILE, this.getPublicKey().getEncoded());
            this.writeToFile(PRIVATE_KEY_FILE, this.getPrivateKey().getEncoded());
            System.out.println("Generated!");
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        try {
            new GenerateKeyRSA(1024).generateKeyToFile();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}