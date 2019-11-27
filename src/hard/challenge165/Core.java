package hard.challenge165;

import java.util.Random;

public class Core {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        Forest forest = new Forest();
        long startTime = System.nanoTime();
        while (forest.getTick() < 500) {
            forest.tick();
        }
        double d = (System.nanoTime() - startTime) / 1000000.0;
        System.out.println(d / 500.0);
    }

}
