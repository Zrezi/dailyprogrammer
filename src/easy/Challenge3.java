package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Welcome to cipher day!
 * <p>
 * Write a program that can encrypt texts with an alphabetical caesar cipher.
 * This cipher can ignore numbers, symbols, and whitespace.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * For extra credit, add a "decrypt" function to your program!
 */
class Challenge3 {

    /**
     * Simple skip-shift function.
     * Turns "Okay then" into "kOyat ehn".
     * Run decrypted messages through this to obtain the original message
     */
    String encrypt(String input) {
        byte[] bytes = input.getBytes();
        for (int i = 0; i < bytes.length - 1; i += 2) {
            byte tmp = bytes[i];
            bytes[i] = bytes[i + 1];
            bytes[i + 1] = tmp;
        }
        return new String(bytes);
    }

}
