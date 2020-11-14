package game;

import java.io.*;

public class Language {
    private int counter;
    private BufferedReader reader;
    private String[] strContainer;
    private String contentLine;

    public Language() {
        try {
            reader = new BufferedReader(new FileReader("Language.txt"));
            contentLine = reader.readLine();
            counter = 1;

            //Set up array dimensions first
            while (contentLine != null) { contentLine = reader.readLine(); counter++; }
            strContainer = new String[counter];
            reader.close();

            //Repeat read (so it starts from the beginning)
            reader = new BufferedReader(new FileReader("Language.txt"));
            contentLine = reader.readLine();
            counter = 1;

            while (contentLine != null) {
/*                if (contentLine.charAt(0) == '#') {     // If string starts with '#' then skip to and add next line to array.
                    contentLine = reader.readLine();
                    strContainer[counter] = contentLine;
                    counter++;
                    break;
                }*/
                strContainer[counter] = contentLine;
                counter++;
                contentLine = reader.readLine();
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }

    public String getLine(int a) {
        return strContainer[a];
    }
}