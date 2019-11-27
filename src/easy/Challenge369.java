package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * One common way for software specifications such as HTML to specify colors is
 * with a hexadecimal string. For instance, the color aquamarine is represented
 * by the string "#7FFFD4". Here's how the string breaks down:
 * <p>
 * - The first character is always "#".
 * - The second and third characters are the red channel value, represented as
 * a hexadecimal value between 00 and FF. In this example, the red channel
 * value is 127, which in hexadecimal is 7F.
 * - The fourth and fifth characters are the green channel value, represented
 * the same way. In this example, the green channel value is 255, which in
 * hexadecimal is FF.
 * - The sixth and seventh characters are the blue channel value, represented
 * the same way. In this example, the blue channel value is 212, which in
 * hexadecimal is D4.
 * <p>
 * All three channel values must be an integer between 0 (minimum brightness)
 * and 255 (maximum brightness). In all cases the hex values are two digits
 * each, including a leading 0 if necessary.
 * <p>
 * Given three integers between 0 and 255, corresponding to the red, green, and
 * blue channel values of a color, find the hex string for that color. You may
 * use anything built into your programming language, such as for base
 * conversion, but you can also do it manually.
 */
class Challenge369 {

    String rgbToHexadecimal(int r, int g, int b) {
        verifyColor(r);
        verifyColor(g);
        verifyColor(b);
        return String.format("#%02x%02x%02x", r, g, b).toUpperCase();
    }

    private void verifyColor(int color) {
        if (0 > color || color > 255) {
            throw new IllegalArgumentException();
        }
    }

}
