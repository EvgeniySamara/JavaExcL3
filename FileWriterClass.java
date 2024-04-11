import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriterClass {
    public static void writeToFile(ArrayList<String> paramslist) {
        String fileName = paramslist.get(0)+".txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName, true); // Append mode
            for (int i = 0; i < paramslist.size(); i++) {
                fileWriter.write(paramslist.get(i) + " ");
            }
            fileWriter.write("\n");
            fileWriter.close();
            System.out.println("Успешно записано в файл.");
        } catch (IOException e) {
            System.out.println("При записи в файл возниикла ошибка.");

        }
    }
}

