package by.bsuir.hairdressingsalon.hairsalonapp.Mailer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class ConvertationHTMLToPDF {

    public void convertToPDF() throws IOException, DocumentException {
        Document document = new Document();
        // Создаем writer для записи в pdf
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
        // Открываем для чтения html страничку
        document.open();
        // Парсим её и записываем в PDF
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("src/main/resources/templates/customer/mainpage.html"));

        document.close();

        System.out.println( "Ваш PDF файл - Создан!" );
    }





}
