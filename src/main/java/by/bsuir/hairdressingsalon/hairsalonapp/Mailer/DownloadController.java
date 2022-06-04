package by.bsuir.hairdressingsalon.hairsalonapp.Mailer;


import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY1;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY2;
import by.bsuir.hairdressingsalon.hairsalonapp.entity.PY3;
import by.bsuir.hairdressingsalon.hairsalonapp.service.CustomerService;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY1Service;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY2Service;
import by.bsuir.hairdressingsalon.hairsalonapp.service.PY3Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class DownloadController {



    private final CustomerService customerService;
    private final PY1Service py1Service;

    private final PY2Service py2Service;
    private final PY3Service py3Service;

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
    public void downloadFile1(@PathVariable Long id, HttpServletResponse response) throws IOException {

        PY1 py1 = py1Service
                .getPY1ById(id)
                .orElseThrow();

        CreatingTXT creatingTXT = new CreatingTXT();

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
    public void downloadWord1(@PathVariable Long id, HttpServletResponse response) throws IOException {

        PY1 py1 = py1Service
                .getPY1ById(id)
                .orElseThrow();

        CreatingTXT creatingTXT = new CreatingTXT();

        File file = new File("C:\\Users\\Varvara\\OneDrive\\Рабочий стол\\fszn\\src\\main\\resources\\purchase_order.pdf");
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
    public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws IOException {

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
    public void downloadWord(@PathVariable Long id, HttpServletResponse response) throws IOException {

        PY2 py2 = py2Service
                .getPY2ById(id)
                .orElseThrow();

        CreatingTXT creatingTXT = new CreatingTXT();

        File file = new File("C:\\Users\\Varvara\\OneDrive\\Рабочий стол\\fszn\\src\\main\\resources\\purchase_order.pdf");
        //File file = creatingTXT.CreateFileTXT();

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
    public void downloadFile3(@PathVariable Long id, HttpServletResponse response) throws IOException {

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
