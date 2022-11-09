package LAB_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) throws IOException {
        if(args.length==0){
            System.out.println("Brak argumentów programu.");
            System.exit(0);
        }
        String fileName = args[0];
        String fileLocation = "C:\\Users\\Mateusz\\IdeaProjects\\java college\\data\\"+fileName;
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(fileLocation));
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        int lines = 0;
        while(reader.ready()){
            lines++;
        }

        System.out.println("Liczba wierszy w pliku " + fileName + " wynosi: " + lines);
    }
}
