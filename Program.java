import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
 
    static public ArrayList<String> parseString(String inputstring) {
        ArrayList<String> paramslist = new ArrayList<String>();
        for (String val : inputstring.split(" ")) {
            //System.out.println(val);
            paramslist.add(val);
        }
        return paramslist;
    }

    public static boolean isAlpha(String string) {
        char[] chars = string.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
    public static String dateConverter(String dateString) throws Checkparamsexc  {
        //String dateString = "25.12.2022";
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date date = inputFormat.parse(dateString);
            String formattedDate = outputFormat.format(date);
            System.out.println(formattedDate);
            return formattedDate;
        } catch (ParseException e) {
            //System.out.println("Ошибка преобразования даты");
            return null;
        }

    }

    public static void readstring(String inputString) throws Checkparamsexc {
        ArrayList<String> paramslist = parseString(inputString);

        if (paramslist.size() != 6) {
            throw new Checkparamsexc("Не совпадает количество параметров!");}
         for (int i=0; i<paramslist.size(); i++)
         {
             if (i<3&! isAlpha(paramslist.get(i))) {
                 throw new Checkparamsexc("ФИО содержит символы отличные от букв!");
             }
             if (i==3)
             {
                 String formattedDate = dateConverter(paramslist.get(i));
             }
             System.out.println(paramslist.get(i));
         }


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите параметры через пробел: Фамилия Имя Отчество дата _ рождения номер _ телефона пол: ");
        System.out.println("(фамилия, имя, отчество - строки дата _ рождения - строка формата dd.mm.yyyy номер _ телефона - целое беззнаковое число без форматирования пол - символ латиницей f или m.)");

        String inputString = in.nextLine();

        try {
            readstring(inputString);
        } catch (Checkparamsexc e) {
            System.out.println(e.getMessage());
        }

        in.close();
    }
}