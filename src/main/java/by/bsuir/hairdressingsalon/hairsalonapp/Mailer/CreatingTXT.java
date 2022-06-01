package by.bsuir.hairdressingsalon.hairsalonapp.Mailer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingTXT {

    public void CreateTxt() {

        File myFile = new File("file.txt");
        try
        {
            FileWriter writer = new FileWriter(myFile);
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }



    public CreatingTXT() throws IOException {
    }
}
