package game;

import java.io.*;

public class Language {
    private BufferedReader reader;
    private String contentLine;

    public String getLine(int lineNumber) {
        try {
            reader = new BufferedReader(new FileReader("Language.txt"));
            contentLine = reader.readLine();

            //Set up array dimensions first
            for (int i = 1; i < lineNumber; i++) {
                if (contentLine != null) {
                    contentLine = reader.readLine();
                }
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

        return contentLine;
    }
}