package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Today's challenge is to calculate the additive persistence of a number,
 * defined as how many loops you have to do summing its digits until you
 * get a single digit number. Take an integer N:
 * <p>
 * 1. Add its digits
 * 2. Repeat until the result has 1 digit
 * <p>
 * The total number of iterations is the additive persistence of N.
 * <p>
 * Your challenge today is to implement a function that calculates the
 * additive persistence of a number.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * The really easy solution manipulates the input to convert the number to
 * a string and iterate over it. Try it without making the number a string,
 * decomposing it into digits while keeping it a number.
 * <p>
 * On some platforms and languages, if you try and find ever larger
 * persistence values you'll quickly learn about your platform's big integer
 * interfaces (e.g. 64 bit numbers).
 */
class Challenge374 {

    long calculateAdditivePersistence(long number) {
        long persistence = 0;
        while (number > 9) {
            number = iterate(number);
            persistence++;
        }
        return persistence;
    }

    private long iterate(long n) {
        long total = 0;
        while (n > 0) {
            total += n % 10;
            n /= 10;
        }
        return total;
    }

}
