package by.bsuir.hairdressingsalon.hairsalonapp.docx4j;

import by.bsuir.hairdressingsalon.hairsalonapp.Mailer.ConvertationHTMLToPDF;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import com.itextpdf.text.DocumentException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class DoxController {

    static final String resourcesPath = System.getProperty("user.dir") + File.separator + "src//main//resources//";
    static final String docxPath = resourcesPath + "docx" + File.separator;

    public static void a(){

        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        BasicConfigurator.configure();

        replaceTest();

    }


    @GetMapping("/word")
    public @ResponseBody
    ResponseEntity<String> createWord(@AuthenticationPrincipal Customer customer, Model model) throws DocumentException, IOException {

        model.addAttribute("customer", customer);
        String email = customer.getEmail();

        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        BasicConfigurator.configure();

        replaceTest();

        return new ResponseEntity<>("Ворд создан", HttpStatus.OK);
    }


    public static void mergeTest(){

        List<String> docs = new ArrayList<>();
        docs.add(docxPath + "exmp1.docx");
        docs.add(docxPath + "exmp2.docx");

        String outputDoc = resourcesPath + "output//merged-doc.docx";

        System.out.println("Merging is started.");

        MergeDocs.merge(docs, outputDoc);

        System.out.println("Merging is finished.");
    }

    public static void replaceTest(){

        String templateDoc = docxPath + "PY1_I.docx";
        String outputDoc = resourcesPath + "output//replaced-doc.docx";

        HashMap<String, String> maps = new HashMap<>();
        maps.put("511111111", "Mary");
        maps.put("how", "How about you? щ");
        maps.put("me", "Me too.");

        System.out.println("Replacing is started.");

        ReplaceVariables.replace(templateDoc, outputDoc, maps);

        System.out.println("Replacing is finished.");
    }


    @GetMapping("/py1word")
    public @ResponseBody
    ResponseEntity<String> createWordPY1(@AuthenticationPrincipal Customer customer, Model model) throws DocumentException, IOException {

        model.addAttribute("customer", customer);
        String email = customer.getEmail();

        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        BasicConfigurator.configure();

        String templateDoc = docxPath + "PY1_I.docx";
        String outputDoc = resourcesPath + "output//PY1_I.docx";

        HashMap<String, String> maps = new HashMap<>();
        maps.put("511111111", "Mary");
        maps.put("how", "How about you? щ");
        maps.put("me", "Me too.");

        System.out.println("Replacing is started.");

        ReplaceVariables.replace(templateDoc, outputDoc, maps);

        System.out.println("Replacing is finished.");

        return new ResponseEntity<>("Ворд создан", HttpStatus.OK);
    }

    @GetMapping("/py2word")
    public @ResponseBody
    ResponseEntity<String> createWordPY2(@AuthenticationPrincipal Customer customer, Model model) throws DocumentException, IOException {

        model.addAttribute("customer", customer);
        String email = customer.getEmail();

        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        BasicConfigurator.configure();

        String templateDoc = docxPath + "PY2_I.docx";
        String outputDoc = resourcesPath + "output//replaced-doc.docx";

        HashMap<String, String> maps = new HashMap<>();
        maps.put("511111111", "Mary");
        maps.put("how", "How about you? щ");
        maps.put("me", "Me too.");

        System.out.println("Replacing is started.");

        ReplaceVariables.replace(templateDoc, outputDoc, maps);

        System.out.println("Replacing is finished.");

        return new ResponseEntity<>("Ворд создан", HttpStatus.OK);
    }

    @GetMapping("/py3word")
    public @ResponseBody
    ResponseEntity<String> createWordPY3(@AuthenticationPrincipal Customer customer, Model model) throws DocumentException, IOException {

        model.addAttribute("customer", customer);
        String email = customer.getEmail();

        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        BasicConfigurator.configure();

        String templateDoc = docxPath + "PY1_I.docx";
        String outputDoc = resourcesPath + "output//replaced-doc.docx";

        HashMap<String, String> maps = new HashMap<>();
        maps.put("511111111", "Mary");
        maps.put("how", "How about you? щ");
        maps.put("me", "Me too.");

        System.out.println("Replacing is started.");

        ReplaceVariables.replace(templateDoc, outputDoc, maps);

        System.out.println("Replacing is finished.");

        return new ResponseEntity<>("Ворд создан", HttpStatus.OK);
    }

}
