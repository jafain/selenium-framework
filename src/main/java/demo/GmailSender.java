package demo;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class GmailSender {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");



        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                        "demo.projekt2@gmail.com",
                        "ntzfkegiwohnobwp"
                    );
                }
            });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("demo.projekt2@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("demo.projekt2@gmail.com")
        );
        message.setSubject("Test");
        message.setText("Hej från Java!");

        Transport.send(message);

        System.out.println("Mail skickat!");
    }
}
