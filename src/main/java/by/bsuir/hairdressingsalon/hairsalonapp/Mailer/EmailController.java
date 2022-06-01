package by.bsuir.hairdressingsalon.hairsalonapp.Mailer;

import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/email")
@PreAuthorize(value = "hasAuthority('USER')")
public class EmailController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    EmailService emailService;

    @GetMapping(value = "/simple-email/")
    public @ResponseBody
    ResponseEntity<String> sendSimpleEmail(@AuthenticationPrincipal Customer customer, Model model) {

        model.addAttribute("customer", customer);
        String email = customer.getEmail();

        try {
            emailService.sendSimpleEmail(email, "Welcome", "This is email for your!!");
        } catch (MailException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            LOG.error("Error while sending out email..{}", mailException.fillInStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }

    @GetMapping(value = "/createtxt/")
    public @ResponseBody
    ResponseEntity<String> createTXT(@AuthenticationPrincipal Customer customer, Model model) throws IOException {

        model.addAttribute("customer", customer);
        String email = customer.getEmail();
        CreatingTXT creatingTXT = new CreatingTXT();

        creatingTXT.CreateTxt();

        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }


    @GetMapping(value = "/simple-order-email/")
    public @ResponseBody
    ResponseEntity<String> sendEmailAttachment(@AuthenticationPrincipal Customer customer, Model model) {

        model.addAttribute("customer", customer);
        String email = customer.getEmail();


        try {
            emailService.sendEmailWithAttachment(email, "Ваша форма ПУ", "Thanks", "classpath:purchase_order.pdf");
        } catch (MessagingException | FileNotFoundException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            LOG.error("Error while sending out email..{}", mailException.fillInStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox. Проверьте Ваши входящие сообщения", HttpStatus.OK);
    }

}