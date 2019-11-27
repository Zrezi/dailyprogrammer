package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * We are given a list of numbers in a "short-hand" range notation where only
 * the significant art of the next number is written because we know the
 * numbers always increasing.
 * <p>
 * (ex. "1,3,7,2,4,1" represents [1, 3, 7, 12, 14, 21])
 * <p>
 * Some people use different separators for their ranges. For example,
 * "1-3,1-2"   == [1, 2, 3, 11, 12]
 * "1:3,1:2"   == [1, 2, 3, 11, 12]
 * "1..3,1..2" == [1, 2, 3, 11, 12]
 * ... and sometimes specify a third digit for their range step, i.e.
 * "1:5:2" represents [1, 3, 5].
 * <p>
 * Note: For this challenge range limits are always inclusive.
 * <p>
 * Our job is to return a list of the complete numbers.
 * The possible separates are ["-", ":", ".."].
 * <p>
 * -----------------------------------------------------------------------------
 * Input Description
 * -----------------------------------------------------------------------------
 * You'll be given strings in the "short-hand" range notation.
 * <p>
 * -----------------------------------------------------------------------------
 * Output Description
 * -----------------------------------------------------------------------------
 * You should output a string of all the numbers separated by a space.
 */
class Challenge292 {

    private static final String REGEX = "[\\:\\-]|\\.\\.";

    String convertToRealNumbers(String input) {
        String[] parts = input.split(",");
        int initialValue = Integer.parseInt(input.split(REGEX)[0]);

        for (int i = 0; i < parts.length; i++) {
            String range = parts[i];
            if (range.contains("-")) {

            } else if (range.contains(":")) {

            } else if (range.contains("..")) {

            } else {
                int intValue = Integer.parseInt(range);
            }
        }

        // TODO Finish

        return String.join(" ", parts);
    }

}
