package by.bsuir.hairdressingsalon.hairsalonapp.Mailer;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

public interface EmailService  {
    void sendSimpleEmail(String email, String welcome, String s);

    void send(SimpleMailMessage var1) throws MailException;

    void sendEmailWithAttachment(String email, String order_confirmation, String thanks_for_your_recent_order, String s) throws MessagingException, FileNotFoundException;
}
