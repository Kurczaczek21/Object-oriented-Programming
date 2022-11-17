package LAB_4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


// java -classpath C:\Users\Mateusz\IdeaProjects\objectprog\src\ LAB_4.FileCopy abc.txt deffffff.txt
public class FileCopy {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Brak argumentów programu.\n" + "Użycie: java FileCopy <source file> <destanation>");
            System.exit(0);
        }

        String sourceFileLocation = args[0];
        Path pathIn = Paths.get(sourceFileLocation);
        String destanationFileLocation = args[1];
        Path pathOut = Paths.get(destanationFileLocation);

        File src = new File(sourceFileLocation), dst = new File(destanationFileLocation);

        if (!src.exists()) {
            System.out.println("Plik " + src.getName() + " nie istnieje.");
            System.exit(1);
        }

        if (src.isDirectory()) {
            System.out.println("Plik " + src.getName() + " jest katalogiem.");
            System.exit(1);
        }

        if (!src.canRead()) {
            System.out.println("Brak dostępu do pliku " + src.getName() + ".");
            System.exit(1);
        }

        if (dst.isDirectory()) {
            if (!dst.canWrite()) {
                System.out.println("Brak wymaganych uprawnień do katalogu " + dst.getName() + ".");
                System.exit(1);
            }
            pathOut = Paths.get(destanationFileLocation+"\\"+args[0]);
        }
        if (dst.exists() && !dst.canWrite()) {
            System.out.println("Nie można nadpisać pliku " + dst.getName() + ".");
            System.exit(1);
        }


        try {
            Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
