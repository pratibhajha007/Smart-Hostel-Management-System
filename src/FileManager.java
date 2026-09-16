import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    private static final String DATA_FOLDER = "data";

    public static void createDataFolder() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void saveData(String fileName, String data) {

        createDataFolder();

        try {

            FileWriter writer = new FileWriter(
                    DATA_FOLDER + "/" + fileName
            );

            writer.write(data);
            writer.close();

        } catch (IOException e) {

            System.out.println("Could not save data.");
        }
    }

    public static List<String> readData(String fileName) {

        createDataFolder();

        String filePath = DATA_FOLDER + "/" + fileName;

        try {

            File file = new File(filePath);

            if (!file.exists()) {
                return null;
            }

            return Files.readAllLines(
                    Paths.get(filePath)
            );

        } catch (IOException e) {

            System.out.println("Could not read data.");
            return null;
        }
    }
}