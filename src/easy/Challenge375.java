package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * A number is input, and a new number should be output with a 1 added to each
 * of its digits. If you encounter a 9, insert a 10 (don't carry over, just
 * shift things around).
 * <p>
 * For example, 998 becomes 10109.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * This challenge is trivial to do if you map it to a string to iterate over
 * the input, operate, and then cast it back. Instead, try doing it without
 * casting it as a string at any point, keep it numeric (int, float, long,
 * etc) only.
 */
class Challenge375 {

    long calculateNewNumber(long number) {
        if (number < 10) {
            return number + 1;
        }
        long a = number % 10 + 1;
        long b = calculateNewNumber(number / 10) * 10;
        return (a == 10) ? ((b + 1) * 10) : (b + a);
    }

}
