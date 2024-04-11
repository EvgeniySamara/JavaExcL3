import java.util.ArrayList;
import java.util.Scanner;

public class Program {
 
    static public ArrayList<String> parseString(String inputstring) {
        ArrayList<String> paramslist = new ArrayList<String>();
        for (String val : inputstring.split(" ")) {
            System.out.println(val);
            paramslist.add(val);
        }
        return paramslist;
    }

    public static void readstring(String inputString) throws Checkparamsexc {
        ArrayList<String> paramslist = parseString(inputString);

        if (paramslist.size() != 6) {
            throw new Checkparamsexc("Не совпадает количество параметров!");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Фамилия Имя Отчество дата _ рождения номер _ телефона пол: ");
        String inputString = in.nextLine();

        try {
            readstring(inputString);
        } catch (Checkparamsexc e) {
            System.out.println(e.getMessage());
        }

        in.close();
    }
}