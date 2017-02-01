package com.edib.psp.sendmail;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailTLS {
    
    public static void main(String[] args) {
        SendMailTLS sendMail = new SendMailTLS();
        
        sendMail.send();
    }

    public void send() {

        final String userName = "zzzzzzzzzz";
        final String password = "zzzzzzzzzz";
        final String urlServer = "zzzzzzzzzz";
        final String port = "587";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", urlServer);
        properties.put("mail.smtp.port", port);

        Session session;
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(userName,password);  
            }
        });
        
        
        Message message = new MimeMessage(session);
        
        try {
            message.setFrom(new InternetAddress("zzzzzzzzzz@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("zzzzzzzzzz@gmail.com,zzzzzzzzzz@gmail.com"));
            
            message.setSubject("Hello!");
            message.setText("Hello World!");           
            
            Logger.getLogger(SendMailTLS.class.getName()).log(Level.INFO, "We're sending...");
            
            Transport.send(message);
            
             Logger.getLogger(SendMailTLS.class.getName()).log(Level.INFO, "Sent!");
            
        } catch (AddressException ex) {
            Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
