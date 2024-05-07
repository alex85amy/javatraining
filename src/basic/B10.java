package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class B10 {
    public static void main(String[] args) {
        String filePath = "C:\\IDEA\\javatraining\\Hello.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




