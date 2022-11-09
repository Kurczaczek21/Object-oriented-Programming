package LAB_4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileAndURLCopy {
    public static void main(String[] args) throws IOException {
        if (args.length > 2) {
            System.out.println("Brak argumentów programu.\n" + "Użycie: java FileCopy <source file> <destanation>");
            System.exit(0);
        }

        String sourceFileLocation = "C:\\Users\\Mateusz\\IdeaProjects\\java college\\data\\" + args[0];
        Path pathIn = Paths.get(sourceFileLocation);
        String destanationFileLocation = "C:\\Users\\Mateusz\\IdeaProjects\\java college\\data\\" + args[1];
        Path pathOut = Paths.get(destanationFileLocation);

        File src = new File(sourceFileLocation), dst = new File(destanationFileLocation);

        if (!isValidURL(args[0])) { // Jest plikiem:
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
        }
        if (dst.isDirectory()) { // Jest katalogiem:
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
            if (isValidURL(args[0])) {
                URL url = new URL(args[0]);
                InputStream is = new URL(args[0]).openStream();
                String x =url.getPath();
                pathIn = Paths.get(x);
                System.out.println("SSSSssssssssss");
                Files.copy(is, pathOut, StandardCopyOption.REPLACE_EXISTING);
            } else {
                Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e){
                e.printStackTrace();
            }
        }
    public static boolean isValidURL(String urlString) {
        try {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
