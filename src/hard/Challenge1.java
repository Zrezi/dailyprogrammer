package hard;

import java.util.Random;
import java.util.Scanner;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * We all know the classic "guessing game" with higher or lower prompts. lets do a role reversal; you create a program
 * that will guess numbers between 1-100, and respond appropriately based on whether users say that the number is too
 * high or too low.
 * <p>
 * Try to make a program that can guess your number based on user input and great code!
 */
public class Challenge1 {

    private static final String INTRODUCTION = "I will guess a number. Tell me if that number is one of the following:\n" +
            "\t* (L)ower\n" +
            "\t* (H)igher\n" +
            "\t* (E)qual";
    private static final String QUESTION = "Is %d higher, lower, or equal to your number? ";
    private static final String CHEATING = "That's not fair, you're cheating!";
    private static final String UNKNOWN = "Invalid entry, try again!";
    private static final String HIGHER = "%d was higher than your number.";
    private static final String LOWER = "%d was lower than your number.";
    private static final String EQUAL = "%d was your number! I win!";

    private Scanner scanner;
    private Random random;

    public Challenge1() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    private void start() {
        System.out.println(INTRODUCTION);
        boolean hasWon = false;
        boolean guessNewNumber = true;
        int guess = 0;
        int lowerBound = 0;
        int higherBound = 100;

        while (!hasWon) {
            if (guessNewNumber) {
                guess = random.nextInt(higherBound - lowerBound) + lowerBound;
            }
            guessNewNumber = true;
            System.out.printf(QUESTION, guess);

            char first = scanner.next().toLowerCase().charAt(0);
            switch(first) {
                case 'h':
                    System.out.printf(HIGHER, guess);
                    higherBound = guess;
                    break;
                case 'l':
                    System.out.printf(LOWER, guess);
                    lowerBound = guess;
                    break;
                case 'e':
                    System.out.printf(EQUAL, guess);
                    hasWon = true;
                    break;
                default:
                    System.out.print(UNKNOWN);
                    guessNewNumber = false;
            }
        }
    }

    public static void main(String[] args) {
        Challenge1 challenge1 = new Challenge1();
        challenge1.start();
    }

}
