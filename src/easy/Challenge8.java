package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Write a program that will print the song "99 Bottles of Beer on the Wall".
 */
class Challenge8 {

    private static final String LYRICS = "%d %s of beer on the wall, %d %s of beer... Take one down, pass" +
            " it around, %d %s of beer on the wall!";
    private static final String BOTTLES = "bottles";
    private static final String BOTTLE = "bottle";

    private static void sing() {
        int bottles = 99;
        while (bottles > 0) {
            if (bottles != 1) {
                System.out.println(String.format(LYRICS, bottles, BOTTLES, bottles--, BOTTLES, bottles, BOTTLES));
            } else {
                System.out.println(String.format(LYRICS, bottles, BOTTLE, bottles--, BOTTLE, bottles, BOTTLE));
            }
        }
    }

    public static void main(String[] args) {
        sing();
    }

}
