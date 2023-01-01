package com.watch.services.Imp;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Properties;

public class Email {

    public static String email = "nguyendev2001@gmail.com";

    public static String pass = "rlekwxxknpyczggh";

    public static String path = "C:\\Users\\admin\\Desktop\\ATBM\\src\\main\\java\\com\\watch\\services\\Imp\\mau-don-xin-xac-nhan-don-hang.pdf";

    public static void sendMail(String mail, String IDFile) throws Exception {
        Properties properties = new Properties();

        Session session = configEmail(properties);

        Message message = new MimeMessage(session);

        message.setSubject("[No Reply] Notification Client");

        Address address = new InternetAddress(mail);
        message.setRecipient(Message.RecipientType.TO, address);

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart attachment = new MimeBodyPart();
        attachment.attachFile(new File(path));

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<p>Confirm code: <strong>" + IDFile + "</strong></p>", "text/html");
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachment);

        message.setContent(multipart, "UTF-8");

        Transport.send(message);
    }

    public static Session configEmail(Properties properties) {
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, pass);
            }
        });
    }

    public static void sendEmailPrivateKey(String receiveEmail, String privateKey) throws Exception {
        Properties properties = new Properties();

        Session session = configEmail(properties);

        Message message = new MimeMessage(session);

        message.setSubject("[No Reply] Private Key");

        Address address = new InternetAddress(receiveEmail);
        message.setRecipient(Message.RecipientType.TO, address);

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(
                "<p>Private Key: <strong>" + privateKey + "</strong></p><br>"
                  +"<p>(<span style='color:red;'>*</span>) Lưu ý: nếu không phải bạn xin vui lòng bỏ vào thùng rác. Thanks!!!</p>" ,
                "text/html");
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart, "UTF-8");

        Transport.send(message);

    }
}
