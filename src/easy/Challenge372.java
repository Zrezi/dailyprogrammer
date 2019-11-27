package easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Given a String containing only the characters X and Y, find
 * whether there are the same number of Xs and Ys.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * Given a String containing only lowercase letters, find whether
 * every letter that appears in the String appears the same number
 * of times. Don't forget to handle the empty String ("")
 * correctly!
 * <p>
 * Input Description
 * -----------------
 * A String
 * <p>
 * Output Description
 * ------------------
 * True or False
 */
class Challenge372 {

    boolean isBalancedStandard(String input) {
        return countLetter(input, 'x') == countLetter(input, 'y');
    }

    private int countLetter(String input, char letter) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == letter) {
                count++;
            }
        }

        return count;
    }

    boolean isBalancedBonus(String input) {
        if (input.isEmpty()) {
            return true;
        }

        HashMap<Character, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            if (letterMap.containsKey(currentChar)) {
                Integer currentValue = letterMap.get(currentChar);
                letterMap.put(currentChar, currentValue + 1);
            } else {
                letterMap.put(currentChar, 1);
            }
        }

        return new HashSet<>(letterMap.values()).size() == 1;
    }

}
