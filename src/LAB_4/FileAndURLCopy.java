package LAB_4;

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;

public class FileAndURLCopy {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Brak argumentów programu.\n" + "Użycie: java FileCopy <source file> <destanation>");
            System.exit(0);
        }

        String sourceFileLocation = args[0];
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


        try { //jest linkiem do strony
            if (isValidURL(args[0])) {
                URL url = new URL(args[0]);
                URLConnection connection= url.openConnection();
                InputStream stream= connection.getInputStream();
                CopyUrl(url,dst);
            } else { //jest plikiem
                Path pathIn = Paths.get(sourceFileLocation);
                Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch(UnknownHostException e){
            System.out.println("nieprawidlowy adres: "+args[0]);
            System.exit(1);
        }catch(AccessDeniedException e ){
            System.out.println("odmowa dostepu");
            System.exit(1);
        }catch (NoRouteToHostException e){
            System.out.println("nie mozna polaczyc sie z wybranym adresem");
            System.exit(1);
        }catch (IOException e){
                System.out.println(e.getMessage());
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
    public static void CopyUrl(URL url,File koniec) throws IOException {
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(koniec);
        byte[] buffer = new byte[4096];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
    }
}
