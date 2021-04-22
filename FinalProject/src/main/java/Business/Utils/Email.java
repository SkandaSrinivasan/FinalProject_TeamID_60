/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import JxMaps.main.AppConfig;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Skanda
 */
public class Email {

    private static Message mimeMessage;
    private static Session session;

    public Email() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", AppConfig.getInstance().getSMTPEmailHost());
        properties.put("mail.smtp.port", AppConfig.getInstance().getSMTPEmailPort());
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(AppConfig.getInstance().getSMTPFromEmail(), AppConfig.getInstance().getSMTPFromEmailPassword());
            }
        });
        mimeMessage = new MimeMessage(session);
    }

    public void sendEmailWithSubject(String toAddress, String subject, String message) {
        try {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(message, "text/html");
            mimeMessage.setSentDate(new Date());
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailWithSubjectToMany(List<String> toAddresses, String subject, String message) {
        try {
            mimeMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(String.join(",", toAddresses)));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            mimeMessage.setSentDate(new Date());
            mimeMessage.setContent(message, "text/html");
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
