package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Write a function that takes two strings and removes from the first string
 * any character that appears in the second string. For instance, if the first
 * string is "Daily Programmer", and the second string is "aeiou ", the result
 * is "DlyPrgrmmr". Note, the second string has [space] so the space between
 * "Daily Programmer" is removed.
 */
class Challenge16 {

    String removeSecondCharactersFromFirst(String first, String second) {
        return first.replaceAll("[" + second + "]", "");
    }

}
