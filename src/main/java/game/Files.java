package game;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;


public class Files {
    public static void main(String[] args) {
        try {
            File myObj = new File("Strings.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else
                System.out.println("File already exists.");

        } catch (IOException e) {
            System.out.println("An error ocurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myappend = new FileWriter("Strings.txt");
            myappend.write("xd string haha");
            myappend.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("Strings.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


