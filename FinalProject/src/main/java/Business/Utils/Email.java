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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.simplejavamail.api.email.Recipient;
import org.simplejavamail.api.mailer.AsyncResponse;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

/**
 *
 * @author Skanda
 */
public class Email {

    private static Message mimeMessage;
    private static Session session;
    private static Mailer asyncMailer;

    public Email() {
        asyncMailer = MailerBuilder
                .withSMTPServer(AppConfig.getInstance().getSMTPEmailHost(),
                        Integer.valueOf(AppConfig.getInstance().getSMTPEmailPort()),
                        AppConfig.getInstance().getSMTPFromEmail(),
                        AppConfig.getInstance().getSMTPFromEmailPassword())
                .withTransportStrategy(TransportStrategy.SMTPS)
                .async()
                .buildMailer();
    }

    public Email(boolean useDeprecated) {
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
        org.simplejavamail.api.email.Email email = EmailBuilder.startingBlank()
                .from(AppConfig.getInstance().getSMTPFromEmail())
                .to(toAddress)
                .withSubject(subject)
                .withHTMLText(message)
                .buildEmail();
        asyncMailer.sendMail(email);
    }

    public void sendEmailWithSubjectToMany(List<String> toAddresses, String subject, String message) {

        org.simplejavamail.api.email.Email email;
        try {
            email = EmailBuilder.startingBlank()
                    .from(AppConfig.getInstance().getSMTPFromEmail())
                    .toMultipleAddresses(Arrays.asList(InternetAddress.parse(String.join(",", toAddresses))))
                    .withSubject(subject)
                    .withHTMLText(message)
                    .buildEmail();
            asyncMailer.sendMail(email);
        } catch (AddressException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendEmailWithSubjectV1(String toAddress, String subject, String message) {

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

    public void sendEmailWithSubjectToManyV1(List<String> toAddresses, String subject, String message) {
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
