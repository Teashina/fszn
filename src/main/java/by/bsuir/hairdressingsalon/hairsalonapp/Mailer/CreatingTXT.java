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

    public File CreateFileTXT() {

        File myFile = new File("file.txt");
        try
        {
            FileWriter writer = new FileWriter(myFile);
            // запись всей строки
            String text = " ЗГЛВ=1.7=\n" +
                    "<ПАЧК=511111111=515002525=ИП СЕРЁГИН=PU1_515002525_511111111_0_000000_20220522194348= = =1=\n" +
                    "    ТИПД=ПУ-1=1= = = = =>\n" +
                    "<ПУ-1=Р=515002525=ВОЯНЕЦ=ВАРВАРА=АЛЕКСАНДРОВНА=Ж=112=16/06/2001=МИНСК= = =БЕЛАРУСЬ= = =19/08/2015=ЛЕЛЬЧИЦКИМ РОВД ГОМЕЛЬСКОЙ ОБЛАСТИ=6160601H012PB2= =УЛ ЮБИЛЕЙНАЯЯ ДОМ 8 КВ 1= = =22/05/2022= = = = = =>\n";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return myFile;

    }









    public CreatingTXT() throws IOException {
    }
}
