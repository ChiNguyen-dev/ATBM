package com.watch.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Properties;

public class Email {
    public static void sendMail(String mail,String IDFile) throws Exception {
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
                return new PasswordAuthentication("nguyendev2001@gmail.com", "rlekwxxknpyczggh");
            }
        });
        Message message = new MimeMessage(session);
        message.setSubject("Thông báo khách hàng");

        Address address = new InternetAddress(mail);
        message.setRecipient(Message.RecipientType.TO, address);

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart attachment = new MimeBodyPart();
        attachment.attachFile(new File("C:\\Users\\admin\\Desktop\\ATBM\\src\\main\\java\\com\\watch\\services\\Imp\\mau-don-xin-xac-nhan-don-hang.pdf"));

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<p>Mã xác nhận: <strong>" + IDFile + "</strong></p>","text/html");
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachment);

        message.setContent(multipart,"UTF-8");

        Transport.send(message);
    }
}
