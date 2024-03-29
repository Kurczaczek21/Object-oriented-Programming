package LAB_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


//java -classpath C:\Users\Mateusz\IdeaProjects\objectprog\out\production\objectprog LAB_4.WordCounter
/*
    4
    uruchamienie w terminalu
    nazwa klasy nazwapliku
    cwiczenie opcji

    5
    start bez param
    z param
    url nazwa pliku

    wyjscie = wejscie i czy kopiuje plik
 */
public class WordCounter {
    public static void main(String[] args) throws IOException {
        if (args.length == 0 || args.length > 4) {
            System.out.println("Brak argumentów programu.");
            System.exit(0);
        }
        String fileName = "";
        String arguments ="";
        boolean doAll = false;

        for(int i =0;i< args.length;i++){
            if (!args[i].startsWith("-")) {
                fileName = args[i];
                continue;
            }
            arguments+=args[i];
        }
        if(arguments.length() == 0){
            doAll = true;
        }

        String fileLocation = fileName;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileLocation));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        int lines = 0;
        int characters = 0;
        int words=0;
        try {
            String line = Files.readAllLines(Paths.get(fileLocation)).get(1);
            lines = Files.readAllLines(Paths.get(fileLocation)).size();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        for (int i = 0; i < lines; i++) {
            String[] wordsInLine = Files.readAllLines(Paths.get(fileLocation)).get(i).split("\\s+");
            words += wordsInLine.length;
            characters += Files.readAllLines(Paths.get(fileLocation)).get(i).length();
        }

        if(arguments.contains("l") || doAll) {
            System.out.println("wierszy: " + lines);
        }
        if(arguments.contains("c") || doAll) {
            System.out.println("znaków: " + characters);
        }
        if(arguments.contains("w") || doAll) {
            System.out.println("słów: " + words);
        }
    }
}
