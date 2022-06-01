package by.bsuir.hairdressingsalon.hairsalonapp.Mailer;


import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ConvertationController {

@GetMapping ("/converter")
public @ResponseBody
ResponseEntity<String> convertPDF(@AuthenticationPrincipal Customer customer, Model model) throws DocumentException, IOException {

    model.addAttribute("customer", customer);
    String email = customer.getEmail();
    try
    {
    ConvertationHTMLToPDF convertationHTMLToPDF = new ConvertationHTMLToPDF();
    convertationHTMLToPDF.convertToPDF();
    }
    catch(DocumentException ex){
        System.out.println(ex.getMessage());
    }
    return new ResponseEntity<>("ПДФ сконвертировано", HttpStatus.OK);
}
}
