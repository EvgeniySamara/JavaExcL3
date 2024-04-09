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

    static public void readsring() throws Exception
    {
        
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Фамилия Имя Отчество дата _ рождения номер _ телефона пол");
        String inputString = in.nextLine();
        // System.out.println(inputString);
        ArrayList<String> paramslist = parseString(inputString);

        // System.out.printf("Ваш номер: %d \n", num);
        in.close();
    } 


}