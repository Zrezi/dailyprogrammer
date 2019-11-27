package easy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * This challenge comes to us from Nagasgura.
 * <p>
 * The human body goes through 90 minute sleep cycles during the night, and you
 * feel more refreshed if you wake up at the end of a sleep cycle than if you
 * wake up during a sleep cycle. The challenge is to make a program that takes
 * a wake-up time and outputs the possible times to fall asleep so that you
 * will wake up at the end of a sleep cycle.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * Be able to input a sleep time and output potential wake up times.
 * <p>
 * Also, account for how long it takes to fall asleep.
 * <p>
 * -----------------------------------------------------------------------------
 * Input Description
 * -----------------------------------------------------------------------------
 * Wake-up time, like 6:15 AM
 * <p>
 * -----------------------------------------------------------------------------
 * Output Description
 * -----------------------------------------------------------------------------
 * When to go to sleep, or a list of 9:15 PM, 10:45 PM, 12:15 AM, 1:45 AM.
 */
class Challenge100 {

    private static final String SPACE = "\n";
    private static final String INVALID_SELECTION = "That selection was invalid. Try again!";
    private static final String INVALID_TIME_FORMAT = "Invalid Time Format";

    private static final SimpleDateFormat FULL_TIME_FORMAT = new SimpleDateFormat("hh:mm aa");
    private static final SimpleDateFormat MILITARY_TIME_FORMAT = new SimpleDateFormat("HH:mm");
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
                    .withLocale(Locale.ENGLISH)
                    .withZone(ZoneId.systemDefault());

    private boolean running = true;
    private Scanner scanner;

    private Challenge100() {
        scanner = new Scanner(System.in);
    }

    private void start() {
        while (running) {
            printMenu();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    calculateWakeUpTimes();
                    break;
                case 2:
                    calculateSleepTimes();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println(INVALID_SELECTION);
            }
            System.out.println(SPACE);
        }
    }

    private void printMenu() {
        System.out.println("    1) Input sleep time");
        System.out.println("    2) Input wake-up time");
        System.out.println("    3) Exit");
        System.out.print("Select an option: ");
    }

    private void calculateWakeUpTimes() {
        System.out.print("Input sleep time: ");
        Instant instant = getInstantFromInput(scanner.nextLine())
                .plus(4, ChronoUnit.HOURS)
                .plus(30, ChronoUnit.MINUTES);

        for (int i = 0; i < 4; i++) {
            instant = instant.plus(1, ChronoUnit.HOURS).plus(30, ChronoUnit.MINUTES);
            System.out.println(formatter.format(instant));
        }
    }

    private Instant getInstantFromInput(String input) {
        try {
            if (input.contains(" ")) {
                return FULL_TIME_FORMAT.parse(input).toInstant();
            } else {
                return MILITARY_TIME_FORMAT.parse(input).toInstant();
            }
        } catch (ParseException pe) {
            throw new RuntimeException(INVALID_TIME_FORMAT);
        }
    }

    private void calculateSleepTimes() {
        System.out.print("Input wake-up time: ");
        Instant instant = getInstantFromInput(scanner.nextLine())
                .minus(4, ChronoUnit.HOURS)
                .minus(30, ChronoUnit.MINUTES);

        for (int i = 0; i < 4; i++) {
            instant = instant.minus(1, ChronoUnit.HOURS).minus(30, ChronoUnit.MINUTES);
            System.out.println(formatter.format(instant));
        }
    }

    public static void main(String[] args) {
        Challenge100 challenge100 = new Challenge100();
        challenge100.start();
    }

}
