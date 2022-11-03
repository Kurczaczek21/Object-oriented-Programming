package LAB_4;

import java.io.BufferedReader;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.out.println("Użycie: java FileCopy source_file target");
            System.exit(0);
        }
        String source = args[0];
        String destanation = args[1];
        String sourceFileLocation = "C:\\Users\\Mateusz\\IdeaProjects\\java college\\data\\" + source;
        BufferedReader reader = null;
    }
}
