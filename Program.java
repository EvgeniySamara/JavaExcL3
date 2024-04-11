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
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }


    public static boolean isNumber(String string) {
            char[] chars = string.toCharArray();

            for (char c : chars) {
                if(!Character.isDigit(c)) {
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
//            System.out.println(formattedDate);
            return formattedDate;
        } catch (ParseException e) {
            //System.out.println("Ошибка преобразования даты");
            return null;
        }

    }

    public static ArrayList<String> readString(String inputString) throws Checkparamsexc {
        ArrayList<String> paramslist = parseString(inputString);

        if (paramslist.size() != 6) {
            throw new Checkparamsexc("Не совпадает количество параметров!");}

         for (int i=0; i<paramslist.size(); i++)
         {
             switch (i) {
                 case  0:
                 case  1:
                 case  2:
                     if (! isAlpha(paramslist.get(i))) {
                         throw new Checkparamsexc("ФИО содержит символы отличные от букв!");
                     }
                     break;
                 case 3:
                     String formattedDate = dateConverter(paramslist.get(i));
                     if (formattedDate == null)  throw new Checkparamsexc("Ошибка в формате даты!");
                     break;
                 case 4:
                     if (! isNumber((paramslist.get(i))))
                     {
                         throw new Checkparamsexc("Телефонный номер содержит символы отличные от цифр!");
                     }
                     break;
                 case 5:
                     if (paramslist.get(i).equals("f")|paramslist.get(i).equals("m")){}
                     else
                     {
                         throw new Checkparamsexc("Некоректно указан пол!");
                     }
                     break;

             }

         }
        return paramslist;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        ArrayList<String> paramslist = new ArrayList<>();
        while (flag)
        {
            System.out.println("Введите параметры через пробел: Фамилия Имя Отчество дата _ рождения номер _ телефона пол: ");
            System.out.println("(фамилия, имя, отчество - строки дата _ рождения - строка формата dd.mm.yyyy номер _ телефона - целое беззнаковое число без форматирования пол - символ латиницей f или m.)");

            String inputString = in.nextLine();

            try {
                paramslist=readString(inputString);
                FileWriterClass.writeToFile(paramslist);
            } catch (Checkparamsexc e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Для выхода введите 'q' или любое другое значение для продолжения");
            inputString = in.nextLine();
            if (inputString.equals("q")) {flag = false;}
        }
        in.close();
    }
}