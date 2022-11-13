package LAB_4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
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

        String sourceFileLocation = args[0];
        Path pathIn = Paths.get(sourceFileLocation);
        String destanationFileLocation = args[1];
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
                copy(url,dst);

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
    private static void copy(URL url, File dest) throws IOException {

        HttpURLConnection huc =  ( HttpURLConnection )  url.openConnection();
        huc.setRequestMethod ("GET");
        huc.connect() ;
        int code = huc.getResponseCode();
        if (code < 200 || code > 299) {
            System.out.println("Adres " + url.toString() + " zwraca status " + code + ".");
            System.exit(1);
        }

        FileOutputStream os = null;

        try {
            ReadableByteChannel is = Channels.newChannel(url.openStream());
            os = new FileOutputStream(dest);

            os.getChannel().transferFrom(is, 0, Long.MAX_VALUE);
        } finally {
            os.close();
        }
    }
}
