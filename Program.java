import java.util.ArrayList;
import java.util.Scanner;

public class Program
{
 
    static public ArrayList<String> parseString(String inputstring)
    {
        ArrayList<String> params = new ArrayList<String>();
        for (String val: inputstring.split(" "))
        {
            System.out.println(val);
            params.add(val);
        }
        return params;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите Фамилия Имя Отчество дата_рождения номер_телефона пол: ");
        String inpuString = in.nextLine();
        ArrayList<String> paramslist = parseString(inpuString);

        // System.out.printf("Ваш номер: %d \n", num);
        in.close();
    }


}