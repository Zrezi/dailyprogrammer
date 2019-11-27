package easy;

import java.util.HashMap;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * No more hiding from your alarm clock! You've decided you
 * want your computer to keep you updated on the time so you're
 * never late again. A talking clock takes a 24-hour time and
 * translates it into words.
 * <p>
 * Input Description
 * -----------------
 * An hour (0-23) followed by a colon followed by the minute (0-59).
 * <p>
 * Output Description
 * ------------------
 * The time in words, using 12-hour format followed by AM or PM.
 */
class Challenge321 {

    private static final HashMap<String, String> timeInWords;

    static {
        timeInWords = new HashMap<>();
        timeInWords.put("00", "");
        timeInWords.put("0", "oh");
        timeInWords.put("1", "one");
        timeInWords.put("2", "two");
        timeInWords.put("3", "three");
        timeInWords.put("4", "four");
        timeInWords.put("5", "five");
        timeInWords.put("6", "six");
        timeInWords.put("7", "seven");
        timeInWords.put("8", "eight");
        timeInWords.put("9", "nine");
        timeInWords.put("10", "ten");
        timeInWords.put("11", "eleven");
        timeInWords.put("12", "twelve");
        timeInWords.put("13", "thirteen");
        timeInWords.put("14", "fourteen");
        timeInWords.put("15", "fifteen");
        timeInWords.put("16", "sixteen");
        timeInWords.put("17", "seventeen");
        timeInWords.put("18", "eighteen");
        timeInWords.put("19", "nineteen");
        timeInWords.put("20", "twenty");
        timeInWords.put("30", "thirty");
        timeInWords.put("40", "fourty");
        timeInWords.put("50", "fifty");
    }

    String convertTimeIntoWords(String input) {
        String[] parts = input.split(":");
        String hour = parts[0];
        String minute = parts[1];
        return String.format("It's %s %s%s",
                convertHourFromTimeIntoWords(hour),
                convertMinuteFromTimeIntoWords(minute),
                convertHourIntoAmOrPm(hour));
    }

    private String convertHourFromTimeIntoWords(String hour) {
        int hourInt = Integer.parseInt(hour);
        if (hourInt == 0) {
            return timeInWords.get("12");
        }
        return hourInt < 13 ? timeInWords.get(String.valueOf(hourInt)) : timeInWords.get(String.valueOf(hourInt - 12));
    }

    private String convertMinuteFromTimeIntoWords(String minute) {
        int minuteInt = Integer.parseInt(minute);
        String first = timeInWords.get(getFirstDigit(minute));
        String second = timeInWords.get(getSecondDigit(minute));
        if (minuteInt > 19) {
            if (second.equals("oh")) {
                return String.format("%s ", first);
            }
            return String.format("%s %s ", first, second);
        } else if (minuteInt > 9) {
            return String.format("%s ", timeInWords.get(minute));
        } else if (minuteInt > 0) {
            return String.format("oh %s ", second);
        } else {
            return "";
        }
    }

    private String getFirstDigit(String minute) {
        return minute.charAt(0) + "0";
    }

    private String getSecondDigit(String minute) {
        return String.valueOf(minute.charAt(1));
    }

    private String convertHourIntoAmOrPm(String hour) {
        return Integer.parseInt(hour) < 12 ? "am" : "pm";
    }

}
