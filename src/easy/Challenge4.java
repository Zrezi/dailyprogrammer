package easy;

import java.util.Random;
import java.util.Scanner;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Your challenge for today is to create a random password generator!
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * For extra credit, allow the user to specify the amount of passwords to
 * generate.
 * <p>
 * For even more extra credit, allow the user to specify the length of the
 * strings he wants to generate!
 */
class Challenge4 {

    private static final String PASSWORD_COUNT = "How many passwords should I generate? ";
    private static final String PASSWORD_LENGTH = "What should the length of each password be? ";

    private Scanner scanner;
    private Random random;

    private Challenge4() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    private void start() {
        System.out.print(PASSWORD_COUNT);
        int passwordCount = scanner.nextInt();

        System.out.print(PASSWORD_LENGTH);
        int passwordLength = scanner.nextInt();

        for (int i = 0; i < passwordCount; i++) {
            System.out.println(generateRandomPassword(passwordLength));
        }
    }

    private String generateRandomPassword(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) (random.nextInt(94) + 33));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Challenge4 challenge4 = new Challenge4();
        challenge4.start();
    }

}
