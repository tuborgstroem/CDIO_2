package game;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;



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
            FileWriter myWriter = new FileWriter("Strings.txt");
            myWriter.write("xd string haha");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


