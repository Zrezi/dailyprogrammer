package easy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Create a program that will ask the user's name, age, and Reddit username.
 * Have it tell them the information back, in the format:
 * <p>
 * your name is (blank), your are (blank) years old, and your username is
 * (blank)
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * For extra credit, have the program log this information in a file to be
 * accessed later.
 */
class Challenge1 {

    private static final String FORMAT_STRING = "your name is %s, you are %s years old, and your username is %s";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = scanner.next();

        System.out.print("How old are you? ");
        String age = scanner.next();

        System.out.print("What is your Reddit username? ");
        String username = scanner.next();

        String output = String.format(FORMAT_STRING, name, age, username);
        System.out.println(output);

        saveToFile(output);
    }

    private static void saveToFile(String output) {
        try {
            File file = new File("Day1Output.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
