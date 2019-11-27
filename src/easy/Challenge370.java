package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * The Universal Product Code (UPC-A) is a bar code used in many parts of the
 * world. The bars encode a 12-digit number used to identify a product for
 * sale, for example:
 * 042100005264
 * <p>
 * The 12th digit (4 in this case) is a redundant check digit, used to catch
 * errors. Using some simple calculations, a scanner can determine, given the
 * first 11 digits, what the check digit must be for a valid code. (Check
 * digits have previously appeared in this subreddit: see Intermediate30 and
 * Easy197). UPC's check digit is calculated as follows:
 * <p>
 * - Sum the digits at odd-numbered positions (1st, 3rd, 5th, ..., 11th). If
 * you use 0-based indexing, this is the even-numbered positions (0th, 2nd,
 * 4th, ..., 10th)
 * - Multiply the result from Step 1 by 3
 * - Take the sum of digits at even-numbered positions (2nd, 4th, 6th, ...,
 * 10th), in the original number, and add this sum to the result from Step 2
 * - Find the result from Step 3 modulo 10 (i.e. the remainder, when divided
 * by 10) and call it M
 * - If M is 0, then the check digit is 0. Otherwise the check digit is 10 - M
 * <p>
 * For example, given the first 11 digits of a UPC 03600029145, you can compute
 * the check digit like this:
 * <p>
 * - Sum the odd-numbered digits (0 + 6 + 0 + 2 + 1 + 5 = 14)
 * - Multiply the result by 3 (14 x 3 = 42)
 * - Add the even-numbered digits (42 + (3 + 0 + 0 + 9 + 4) = 58)
 * - Find the result modulo 10 (58 divided 10 is 5 remainder 8, so M = 8)
 * - If M is not 0, subtract M from 10 to get the check digit
 * (10 - M = 10 - 8 = 2)
 * <p>
 * So the check digit is 2, and the complete UPC is 036000291452.
 * <p>
 * Given an 11-digit number, find the 12th digit that would make a valid UPC.
 * You may treat the input as a string if you prefer, whatever is more
 * convenient. If you treat it as a number, you may need to consider the case
 * of leading 0's to get up to 11 digits. That is, an input of 12345 would
 * correspond to a UPC start of 00000012345.
 */
class Challenge370 {

    private static final int ZERO_ASCII = 48;
    private static final int UPC_LENGTH_WITHOUT_CHECK = 11;

    int calculateUpc(String upc) {
        int[] numbers = numerify(pad(upc).getBytes());
        int temp = (((numbers[0] + numbers[2] + numbers[4] + numbers[6] + numbers[8] + numbers[10]) * 3) +
                (numbers[1] + numbers[3] + numbers[5] + numbers[7] + numbers[9])) % 10;
        return temp == 0 ? 0 : 10 - temp;
    }

    private int[] numerify(byte[] input) {
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = input[i] - ZERO_ASCII;
        }
        return numbers;
    }

    private String pad(String input) {
        return String.format("%" + UPC_LENGTH_WITHOUT_CHECK + "s", input).replaceAll(" ", "0");
    }

}
