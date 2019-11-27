package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * The game of Yahtzee is played by rolling five 6-sided dice, and scoring the
 * results in a number of ways. You are given a Yahtzee dice roll, represented
 * as a sorted list of 5 integers, each of which is between 1 and 6 inclusive.
 * Your task is to find the maximum possible score for this roll in the upper
 * section of the Yahtzee score card. Here's what that means.
 * <p>
 * For the purpose of this challenge, the upper section of Yahtzee gives you
 * six possible ways to score a roll. 1 times the number of 1's in the roll,
 * 2 times the number of 2's in the roll, 3 times the number of 3's in the
 * roll, and so on up to 6 times the number of 6's. For instance, consider the
 * roll [2, 3, 5, 5, 6]. If you scored this as 1's, the score would be 0, since
 * there are no 1's in the roll. If you scored it as 2's, the score would be 2,
 * since there's one 2 in the roll. Scoring the roll in each of the six ways
 * gives you the six possible scores:
 * <p>
 * 0, 2, 3, 0, 10, 6
 * <p>
 * The maximum here is 10 (2x5), so your result should be 10.
 */
class Challenge381 {

    Integer scoreList(List<Integer> roll) {
        List<Integer> sums = new ArrayList<>(Collections.nCopies(6, 0));
        roll.stream()
                .filter(integer -> integer < 7 && integer > 0)
                .forEach(integer -> {
                    int index = integer - 1;
                    Integer currentValue = sums.get(index);
                    sums.set(index, currentValue + integer);
                });

        return sums.stream().max(Integer::compareTo).orElse(-1);
    }

    int scoreArray(int[] roll) {
        int[] sums = new int[6];
        for (int i : roll) {
            sums[i - 1] += i;
        }
        return max(sums);
    }

    private int max(int[] array) {
        int cur = array[0];
        for (int value : array) {
            cur = (value > cur) ? value : cur;
        }
        return cur;
    }

}
