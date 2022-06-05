package by.bsuir.hairdressingsalon.hairsalonapp.Mailer;


import by.bsuir.hairdressingsalon.hairsalonapp.docx4j.ReplaceVariables;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.Customer;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY1;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY2;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY3;
import by.bsuir.hairdressingsalon.hairsalonapp.service.CustomerService;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY1Service;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY2Service;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY3Service;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


@Controller
public class DownloadController {



    private final CustomerService customerService;
    private final PY1Service py1Service;

    private final PY2Service py2Service;
    private final PY3Service py3Service;

    static final String resourcesPath = System.getProperty("user.dir") + File.separator + "src//main//resources//";
    static final String docxPath = resourcesPath + "docx" + File.separator;

    public DownloadController(CustomerService customerService,
                              PY1Service py1Service,
                              PY2Service py2Service,
                              PY3Service py3Service) {
        this.customerService = customerService;
        this.py1Service = py1Service;
        this.py2Service = py2Service;
        this.py3Service = py3Service;

    }
   /*
    public void downloadFile(HttpServletResponse response) throws IOException {

        File file = new File("Purchase Order");

        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposion";
        String headerValue = "attacment; filename=" + file.getName();

        response.setHeader(headerKey,headerValue);
        ServletOutputStream outputStream = response.getOutputStream();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
    outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }

    */


    @GetMapping("/downloader")
    public void downloadFile(HttpServletResponse response) throws IOException {

        CreatingTXT creatingTXT = new CreatingTXT();

        File file = new File("C:\\Users\\Varvara\\OneDrive\\Рабочий стол\\fszn\\src\\main\\resources\\purchase_order.pdf");
        //File file = creatingTXT.CreateFileTXT();

        if (file.getName().indexOf(".txt")>-1) response.setContentType("application/txt");
        if (file.getName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (file.getName().indexOf(".docx")>-1) response.setContentType("application/docx");


        //response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + file.getName();

        response.setHeader(headerKey,headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }




    @GetMapping("/download/txtpy1/{id}")
    public void downloadFile1(@AuthenticationPrincipal Customer customer, @PathVariable Long id, HttpServletResponse response) throws IOException {

        PY1 py1 = py1Service
                .getPY1ById(id)
                .orElseThrow();

        CreatingTXT creatingTXT = new CreatingTXT();
        String email = customer.getEmail();


        File file = creatingTXT.CreateFileTXT();

        if (file.getName().indexOf(".txt")>-1) response.setContentType("application/txt");
        if (file.getName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (file.getName().indexOf(".docx")>-1) response.setContentType("application/docx");


        //response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + py1.getName() + ".txt";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }


    @GetMapping("/download/wordpy1/{id}")
    public void downloadWord1(@AuthenticationPrincipal Customer customer, @PathVariable Long id, HttpServletResponse response) throws IOException {

        PY1 py1 = py1Service
                .getPY1ById(id)
                .orElseThrow();



        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        BasicConfigurator.configure();

        String templateDoc = docxPath + "PY1_R.docx";
        String outputDoc = resourcesPath + "output//PY1_R.docx";

        //String templateDoc = docxPath + "template.docx";
        //String outputDoc = resourcesPath + "output//PY1_R.docx";

        HashMap<String, String> maps = new HashMap<>();
        maps.put("name", "Mary");
        maps.put("how", "How about you?");
        maps.put("me", "Me too.");
        maps.put("id.num", "что-то");
        maps.put("packname", "что-то");
        maps.put("id.fszn", customer.getIdfszn());
        maps.put("ip.name", customer.getIpname());
        maps.put("surname", customer.getSurname());
        maps.put("secname", customer.getSecname());
        maps.put("sex", py1.getSex());
        maps.put("grajd", py1.getCitizenship());
        maps.put("datrBirth", String.valueOf(py1.getDate_of_birth()));
        maps.put("sity", py1.getSity_of_birth() );
        maps.put("contr", py1.getCountry() );
        maps.put("dategive", "тут типа дата" );
        maps.put("indNum", customer.getInsurance());
        maps.put("rovd", "тут типа ровд");
        maps.put("index", py1.getIndeks() );
        maps.put("adress", py1.getAddress() );
        maps.put("specTel", py1.getTelephone());
        maps.put("domTel", py1.getTelephone_home());


        System.out.println("Replacing is started.");

        ReplaceVariables.replace(templateDoc, outputDoc, maps);

        System.out.println("Replacing is finished.");


        File file = new File("src/main/resources/output/PY1_R.docx");
        //File file = creatingTXT.CreateFileTXT();

        if (file.getName().indexOf(".txt")>-1) response.setContentType("application/txt");
        if (file.getName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (file.getName().indexOf(".docx")>-1) response.setContentType("application/docx");


        //response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + py1.getName() + ".docx";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }

    @GetMapping("/download/txtpy2/{id}")
    public void downloadFile(@AuthenticationPrincipal Customer customer, @PathVariable Long id, HttpServletResponse response) throws IOException {

        PY2 py2 = py2Service
                .getPY2ById(id)
                .orElseThrow();

       // CreatingTXT creatingTXT = new CreatingTXT();

        File file = new File("src/main/resources/purchase_order.pdf");
        //File file = creatingTXT.CreateFileTXT();

        if (file.getName().indexOf(".txt")>-1) response.setContentType("application/txt");
        if (file.getName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (file.getName().indexOf(".docx")>-1) response.setContentType("application/docx");


        //response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + py2.getName() + ".txt";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }


    @GetMapping("/download/wordpy2/{id}")
    public void downloadWord(@AuthenticationPrincipal Customer customer, @PathVariable Long id, HttpServletResponse response) throws IOException {

        PY2 py2 = py2Service
                .getPY2ById(id)
                .orElseThrow();

        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        BasicConfigurator.configure();

        String templateDoc = docxPath + "PY2.docx";
        String outputDoc = resourcesPath + "output//PY2.docx";

        //String templateDoc = docxPath + "template.docx";
        //String outputDoc = resourcesPath + "output//PY1_R.docx";

        HashMap<String, String> maps = new HashMap<>();
        maps.put("name", "Mary");
        maps.put("how", "How about you?");
        maps.put("me", "Me too.");
        maps.put("id.num", "что-то");
        maps.put("packname", "что-то");
        maps.put("id.fszn", customer.getIdfszn());
        maps.put("ip.name", customer.getIpname());
        maps.put("surname", customer.getSurname());
        maps.put("secname", customer.getSecname());
        maps.put("straxnum", "1234");
        maps.put("datestart", "1234");
        maps.put("dateprk", "1234");
        maps.put("numprik", "1234");
        maps.put("dategone}", "1234");
        maps.put("datrprk2", "1234");
        maps.put("numprik2", "1234");
        maps.put("codegone", "1234");
        maps.put("CodeWork", "1234");
        maps.put("dolgName", "1234");
        maps.put("strackName", "1234");
        maps.put("dategote", "1234");
        maps.put("dataprik", "1234");
        maps.put("numprikk", "1234");
        maps.put("codetrud", "1234");
        maps.put("dataper", "1234");
        maps.put("dataprikz", "1234");
        maps.put("nummprik", "1234");
        maps.put("dateGett", "1234");
        maps.put("datepriik", "1234");
        maps.put("priiknam", "1234");
        maps.put("razrad", "1234");
        maps.put("KvalKat", "1234");
        maps.put("form", "1234");
        maps.put("todayDate", "1234");





        System.out.println("Replacing is started.");

        ReplaceVariables.replace(templateDoc, outputDoc, maps);

        System.out.println("Replacing is finished.");


        File file = new File("src/main/resources/output/PY2.docx");

        if (file.getName().indexOf(".txt")>-1) response.setContentType("application/txt");
        if (file.getName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (file.getName().indexOf(".docx")>-1) response.setContentType("application/docx");


        //response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + py2.getName() + ".docx";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }


    @GetMapping("/download/txtpy3/{id}")
    public void downloadFile3(@AuthenticationPrincipal Customer customer, @PathVariable Long id, HttpServletResponse response) throws IOException {

        PY3 py3 = py3Service
                .getPY3ById(id)
                .orElseThrow();

        // CreatingTXT creatingTXT = new CreatingTXT();

        File file = new File("src/main/resources/purchase_order.pdf");
        //File file = creatingTXT.CreateFileTXT();

        if (file.getName().indexOf(".txt")>-1) response.setContentType("application/txt");
        if (file.getName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (file.getName().indexOf(".docx")>-1) response.setContentType("application/docx");


        //response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + py3.getName() + ".txt";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }


    @GetMapping("/download/wordpy3/{id}")
    public void downloadWord3(@PathVariable Long id, HttpServletResponse response) throws IOException {

        PY3 py3 = py3Service
                .getPY3ById(id)
                .orElseThrow();

        CreatingTXT creatingTXT = new CreatingTXT();

        File file = new File("C:\\Users\\Varvara\\OneDrive\\Рабочий стол\\fszn\\src\\main\\resources\\purchase_order.pdf");
        //File file = creatingTXT.CreateFileTXT();

        if (file.getName().indexOf(".txt")>-1) response.setContentType("application/txt");
        if (file.getName().indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (file.getName().indexOf(".docx")>-1) response.setContentType("application/docx");


        //response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + py3.getName() + ".docx";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();

    }



}
