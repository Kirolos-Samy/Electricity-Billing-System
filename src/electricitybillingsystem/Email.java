/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package electricitybillingsystem;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author feloa
 */
public class Email {
   
   // meter id 
   public static void sendEmail(String meter ,String recipient) throws Exception{ 
   System.out.print("preparing to send email");
       Properties properties = new Properties();
       
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.ssl.enable", "true");                             
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.port", "465");
   
       String companyEmail= "electricityhelwan4@gmail.com";
       String companyPassword="wxtvjtxaktkmbqwf";
       
       Session session = Session.getInstance(properties, new Authenticator(){
        
       
         @Override
         protected PasswordAuthentication getPasswordAuthentication()
         {   
             return new PasswordAuthentication(companyEmail,companyPassword);
         }
   
   
        });
//       session.setDebug(true);
     try{  
    MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(companyEmail));
     message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
     message.setSubject("Elecrticity Company");
     message.setText("Your Meter ID Is : '"+meter+"' " );
     Transport.send(message);
     System.out.println("message sent");
     }catch(Exception e){
     
     System.out.println("the error is : "+ e.getMessage());
     
     
     }
     
   }
   // reminder of 3 months
   public static void sendEmail2(String recipient) throws Exception{ 
   System.out.print("preparing to send email");
       Properties properties = new Properties();
       
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.ssl.enable", "true");                             
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.port", "465");
   
       String companyEmail= "electricityhelwan4@gmail.com";
       String companyPassword="wxtvjtxaktkmbqwf";
       
       Session session = Session.getInstance(properties, new Authenticator(){
        
       
         @Override
         protected PasswordAuthentication getPasswordAuthentication()
         {   
             return new PasswordAuthentication(companyEmail,companyPassword);
         }
   
   
        });
//       session.setDebug(true);
     try{  
    MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(companyEmail));
     message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
     message.setSubject("Elecrticity Company");
     message.setText("Dear Customer , This is a friendly reminder that we haven't received payment for 3 months. We're not aware of any outstanding issues or reasons for non-payment, so we would like to respectfully ask you to make payment as soon as possible." );
     Transport.send(message);
     System.out.println("message sent");
     }catch(Exception e){
     
     System.out.println("the error is : "+ e.getMessage());
     
     
     }
     
   }

   // complain
   public static void sendEmail3(Complain cmp) throws Exception{ 
   System.out.print("preparing to send email");
       Properties properties = new Properties();
       
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.ssl.enable", "true");                             
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.port", "465");
   
       String companyEmail= "electricityhelwan4@gmail.com";
       String companyPassword="wxtvjtxaktkmbqwf";
       
       Session session = Session.getInstance(properties, new Authenticator(){
        
       
         @Override
         protected PasswordAuthentication getPasswordAuthentication()
         {   
             return new PasswordAuthentication(companyEmail,companyPassword);
         }
   
   
        });
//       session.setDebug(true);
     try{  
    MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(companyEmail));
     message.setRecipient(Message.RecipientType.TO, new InternetAddress(companyEmail));
     message.setSubject("Complain about bill_id : '"+cmp.bill_id+"' for meter_id : '"+cmp.meter_id+"' ");
     message.setText("Complain : '"+cmp.complain+"' " );
     Transport.send(message);
     System.out.println("message sent");
     }catch(Exception e){
     
     System.out.println("the error is : "+ e.getMessage());
     
     
     }



   
   }
}





  
   
