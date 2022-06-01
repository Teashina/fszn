package by.bsuir.hairdressingsalon.hairsalonapp.Mailer;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class DownloadController {

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


}
