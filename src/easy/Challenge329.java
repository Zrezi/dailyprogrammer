package easy;

import java.util.Arrays;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * A Lucky Number is a natural number in a set which is generated by a certain
 * "sieve". This sieve is similar to the Sieve of Eratosthenes that generates
 * primes, but it eliminates numbers based on their position in the remaining
 * set, instead of their value (or position in the initial set of natural
 * numbers).
 * <p>
 * The set of lucky numbers can be obtained by:
 * <p>
 * Begin with a list of integers starting with 1:
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
 * <p>
 * Starting with 1, remove every other element (i.e. every even number) from
 * this set. We are left with:
 * 1 3 5 7 9 11 13 15 17 19 21 23 25
 * <p>
 * After 1, the next number in the set is 3. So, remove every 3rd number.
 * Clearly, 5 is removed because it's the third number in the above set. Go on
 * and keep removing every 3rd number.
 * <p>
 * Your new set is:
 * 1 3 7 9 13 15 19 21 25
 * <p>
 * Here, the next remaining number you have after 3 is 7. Now, at this point,
 * it's obvious that there's no way 1 and 3 are ever getting eliminated. Thus,
 * we can conclude that 1 and 3 are lucky numbers.
 * <p>
 * Now remove every 7th number. Clearly, 19 would be the first to be wiped out.
 * You're left with:
 * 1 3 7 9 13 15 21 25
 * <p>
 * Now it's time to proceed to the next remaining number after 7, i.e., 9.
 * Remove every 9th number. Note that at this point, 7 cannot be eliminated. 7
 * is a lucky number too.
 * <p>
 * Keep proceeding in a similar fashion in order to get a list of lucky
 * numbers.
 * <p>
 * Numbers remaining after this procedure has been carried out completely are
 * called lucky numbers. The first few are:
 * 1 3 7 9 13 15 21 25 31 33 37, ...
 * <p>
 * Today's challenge is to find the nearest lucky number. This might remind you
 * of Challenge #326. In fact, this has been inspired from it. Bruteforcing is
 * the most obvious option, but it's certainly not the most efficient.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * Find every lucky number all the way up to 10,000,000 and post the time
 * it took to run. This is so that you can compete amongst everyone else to
 * see who has the most efficient one.
 */
class Challenge329 {

    private static final int TEN_MILLION = 10000000;

    /**
     * Credit: Reddit user Qwazy_Wabbit
     * Their solution was done in C++ using memmove() and memcpy(), which
     * I adapted to Java's System.arraycopy().
     */
    private static int[] bonus() {
        int[] numbers = new int[(TEN_MILLION / 2) + 1];
        for (int i = 0; i < TEN_MILLION / 2; ++i) {
            numbers[i] = (i * 2) + 1;
        }
        int endPosition = TEN_MILLION / 2;

        for (int position = 1;; ++position) {
            int skip = numbers[position] - 1;
            if (skip > endPosition) {
                return Arrays.copyOf(numbers, endPosition);
            }

            int writePosition = skip;
            int readPosition = skip + 1;
            int lastSkip = endPosition - skip;

            for (; readPosition < lastSkip; writePosition += skip, readPosition += skip + 1) {
                System.arraycopy(numbers, readPosition, numbers, writePosition, skip);
            }

            int lastReadSize = endPosition - readPosition;
            System.arraycopy(numbers, readPosition, numbers, writePosition, lastReadSize);
            endPosition = writePosition + lastReadSize;
        }
    }

}
