package data;

import java.io.File;
import java.io.IOException;

public class FileException {

    public static File fileExceptionTool(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Negalima irasyti failo" + e);
                return null;

            }
        }
        return file;
    }
}
