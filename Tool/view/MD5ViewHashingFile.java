package com.Tool.view;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {


    public static String enscrypt(String plaintext, String privateKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException,
            InvalidKeyException, InvalidKeySpecException {

        PKCS8EncodedKeySpec spectPrivateKey = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey), "RSA");

        KeyFactory kf = KeyFactory.getInstance("RSA");

        PrivateKey pvt = kf.generatePrivate(spectPrivateKey);

        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.ENCRYPT_MODE, pvt);

        byte[] data = cipher.doFinal(plaintext.getBytes());

        return Base64.getEncoder().encodeToString(data);
    }

    public static String descrypt(String plaintext , String publicKey) throws Exception {

        X509EncodedKeySpec publickeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey), "RSA");

        KeyFactory kf = KeyFactory.getInstance("RSA");

        PublicKey pub = kf.generatePublic(publickeySpec);

        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.DECRYPT_MODE, pub);

        byte[] data = cipher.doFinal(Base64.getDecoder().decode(plaintext.getBytes()));

        return new String(data);
    }

    public static void main(String[] args) throws Exception {
        String signature = "vochinguyen";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKmTZIJP8XXFCOfOfBgMKINLJUmTG"
                + "fETUxaas3/C2kaQzrop6xZ7xYaplYevIc+Jqti0K21blwpW9joZDbxCxa9/8yRzf2rcjNhP1eqZeXivKY0CpEl37YLHytPUUHNFk5pUTgCyIfRCh48ohk201hRUvv5IVsY0wJPJwR3yF1mHAgMBAAECgYBXUdmYrLfGkB5k11PZQjF+YiyiNUhPdkb7xc+Wg2zIl3qMLFes7TEqhZrFEq6TYu2Bx0zxdA9TuLHz+sCy56NJQqtIm83DGJ2uN0IO6IDaVZqjwVQyDZX9YpstGXSEFdpJmxOAVirKcs4tp6WMsJqBS04ida67K7MulTWkYnoWGQJBAOtP5eV5JsVayTCZQsVAHQ8HNKUiDGuWvjjCpNYixtPo4+sCDhXU7kfyRubQfj2Lb5KTtyZTcXBNi40Su8l6aIsCQQC4e/xE1VKhPLQL8asIl09dAdB1Dj19ZfR1eoE0IchPyRsI9JfosIPLGydtKRMy7xVCGfA5GlkFECIYIXycEPZ1AkB8R11/PeZJM3Kw1TEbponyZvbaBEqVBC+BIOQYKJPkVcsSUqqHw0b5/q6Nty4FaUBLJPMFLerqyjnbDzrY5WqTAkEAqhSEauFQoJ3aT/ipee4lmNWHXaOXRPit+3DJlUpf5k69we/d7QRvPNz36"
                + "EeqD5cjviEzuzFzSJurExwsSaXJ0QJBAITIAEm3RRnZjO4idOntuGKDB/BFPv2nBFlQUarR4iHiQDvZm/wqOZPQbOSdmsMYfd1kOQVWVFi+44Nz1PoeEvk=";

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCpk2SCT/F1xQjnznwYDCiDSyVJkxnxE1MWmrN/wtpGkM66KesWe8WGqZWHryHPiarYtCttW5cK"
                + "VvY6GQ28QsWvf/Mkc39q3IzYT9XqmXl4rymNAqRJd+2Cx8rT1FBzRZOaVE4AsiH0QoePKIZNtNYUVL7+SFbGNMCTycEd8hdZhwIDAQAB";
        String en = enscrypt(signature, privateKey);
        String de = descrypt(en, publicKey);
        System.out.println(en);
        System.out.println(de);
    }



}
