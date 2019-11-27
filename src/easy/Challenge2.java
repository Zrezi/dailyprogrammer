package easy;

import java.util.Scanner;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Hello, coders! An important part of programming is being able to apply your
 * programs, so your challenge for today is to create a calculator application
 * that has use in your life. It might be an interest calculator, or it might
 * be something that you can use in the classroom. For example, if you were in
 * a physics class, you might want to make a F = M * A calculator.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge                                                           |
 * +---------------------------------------------------------------------------+
 * Make the calculator have multiple functions! Not only should it be able to
 * calculate F = M * A, but also A = F / M and M = F / A!
 */
class Challenge2 {

    private static final String ENTER_FORCE = "Enter (F)orce in N: ";
    private static final String ENTER_MASS = "Enter (M)ass in kg: ";
    private static final String ENTER_ACCELERATION = "Enter (A)cceleration in m/s²: ";
    private static final String INVALID_SELECTION = "That selection was invalid. Try again!";
    private static final String FMA = "Force = %.2fkg * %.2fm/s² = %.2fN\n\n";
    private static final String AFM = "Acceleration = %.2fN / %.2fkg = %.2fm/s²\n\n";
    private static final String MFA = "Mass = %.2fN / %.2fm/s² = %.2fkg\n\n";

    private boolean running = true;
    private Scanner scanner;

    private Challenge2() {
        scanner = new Scanner(System.in);
    }

    private void start() {
        while (running) {
            printMenu();
            switch (scanner.nextInt()) {
                case 1:
                    calculateForce();
                    break;
                case 2:
                    calculateAcceleration();
                    break;
                case 3:
                    calculateMass();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println(INVALID_SELECTION);
            }

        }
    }

    private void printMenu() {
        System.out.println("What would you like to calculate?");
        System.out.println("    1) F = M * A");
        System.out.println("    2) A = F / M");
        System.out.println("    3) M = F / A");
        System.out.println("    4) Exit");
        System.out.print("Enter your selection: ");
    }

    private void calculateForce() {
        System.out.print(ENTER_MASS);
        double mass = scanner.nextDouble();

        System.out.print(ENTER_ACCELERATION);
        double acceleration = scanner.nextDouble();

        double force = mass * acceleration;
        System.out.println(String.format(FMA, mass, acceleration, force));
    }

    private void calculateAcceleration() {
        System.out.print(ENTER_FORCE);
        double force = scanner.nextDouble();

        System.out.print(ENTER_MASS);
        double mass = scanner.nextDouble();

        double acceleration = force / mass;
        System.out.println(String.format(AFM, force, mass, acceleration));
    }

    private void calculateMass() {
        System.out.print(ENTER_FORCE);
        double force = scanner.nextDouble();

        System.out.print(ENTER_ACCELERATION);
        double acceleration = scanner.nextDouble();

        double mass = force / acceleration;
        System.out.println(String.format(MFA, force, acceleration, mass));
    }

    public static void main(String[] args) {
        Challenge2 challenge2 = new Challenge2();
        challenge2.start();
    }

}
