package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Write a program to count the number of years in an inclusive range of years
 * that have no repeated digits.
 * <p>
 * For example, 2012 has a repeated digit (2) while 2013 does not. Given the
 * range [1980, 1987], your program would return 7 (1980, 1982, 1983, 1984,
 * 1985, 1986, 1987).
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * Compute the longest run of years of repeated digits and the longest run of
 * years of non-repeated digits for [1000, 2013].
 */
class Challenge101 {

    int countYearsWithoutRepeatedDigits(int fromYear, int toYear) {
        int count = 0;
        for (int i = fromYear; i < toYear; i++) {
            if (!doesStringHaveRepeatedDigits(String.valueOf(i))) {
                count++;
            }
        }
        return count;
    }

    private Boolean doesStringHaveRepeatedDigits(String input) {
        List<Character> charSet = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Character currentCharacter = input.charAt(i);
            if (charSet.contains(currentCharacter)) {
                return true;
            } else {
                charSet.add(currentCharacter);
            }
        }
        return false;
    }

    private Boolean doesStringNotHaveRepeatedDigits(String input) {
        return !doesStringHaveRepeatedDigits(input);
    }

    List<String> getLongestRunOfYearsWithRepeatingDigits() {
        return applyToYearsAndGetCount(this::doesStringHaveRepeatedDigits);
    }

    List<String> getLongestRunOfYearsWithoutRepeatingDigits() {
        return applyToYearsAndGetCount(this::doesStringNotHaveRepeatedDigits);
    }

    private List<String> applyToYearsAndGetCount(Function<String, Boolean> function) {
        List<String> yearList = getYearList();
        List<String> years = new ArrayList<>();
        List<String> countingYears = new ArrayList<>();
        int maxCount = 0;
        int count = 0;

        for (String year : yearList) {
            if (function.apply(year)) {
                count++;
                countingYears.add(year);
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    years.clear();
                    years.addAll(countingYears);
                }
                countingYears.clear();
                count = 0;
            }
        }

        return years;
    }

    private List<String> getYearList() {
        List<String> yearList = new ArrayList<>();
        for (int i = 1000; i < 2013; i++) {
            yearList.add(String.valueOf(i));
        }
        return yearList;
    }

}
