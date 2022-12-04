package com.watch.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Email {
    public static void sendMail(String mail) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nguyendev2001@gmail.com", "ilmofrmdsikybtri");
            }
        });
        Message message = new MimeMessage(session);
        message.setSubject("Thông báo đặt hàng");

        Address address = new InternetAddress(mail);
        message.setRecipient(Message.RecipientType.TO, address);

        MimeMultipart multipart = new MimeMultipart();

//        MimeBodyPart attachment = new MimeBodyPart();
//        attachment.attachFile("");

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<h1>Đơn hàng của bạn</h1>", "text/html");

        multipart.addBodyPart(messageBodyPart);
//        multipart.addBodyPart(attachment);

        message.setContent(multipart);

        Transport.send(message);
    }
}
