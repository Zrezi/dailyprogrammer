package easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Write a program to left or right justify a text file.
 */
class Challenge15 {

    private static final Alignment ALIGNMENT = Alignment.RIGHT;

    private enum Alignment {
        LEFT(String::trim),
        RIGHT(string -> String.format("%80s", string));

        private Function<String, String> function;

        Alignment(Function<String, String> function) {
            this.function = function;
        }

        public String apply(String input) {
            return function.apply(input);
        }
    }

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("res/easy/Challenge15.txt");
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(ALIGNMENT.apply(line));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
