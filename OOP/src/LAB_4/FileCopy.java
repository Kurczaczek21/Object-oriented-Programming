package LAB_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Brak argumentów programu.\n" + "Użycie: java FileCopy <source file> <destanation>");
            System.exit(0);
        }
        String source = args[0];
        String destanation = args[1];
        String sourceFileLocation = "C:\\Users\\Mateusz\\IdeaProjects\\java college\\data\\" + source;
        Path pathIn = Paths.get(sourceFileLocation);
        String destanationFileLocation = "C:\\Users\\Mateusz\\IdeaProjects\\java college\\data\\" + destanation;
        Path pathOut = Paths.get(destanationFileLocation);

        try {
            Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}
