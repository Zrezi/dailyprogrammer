package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * In mathematics the regular paperfolding sequence, also known as the dragon
 * curve sequence, is an infinite automatic sequence of 0s and 1s. At each
 * stage an alternating sequence of 1s and 0s is inserted around the terms of
 * the previous sequence. The first few generations of the sequence look like
 * this:
 * <p>
 * 1
 * 1 1 0
 * 1 1 0 1 1 0 0
 * 1 1 0 1 1 0 0 1 1 1 0 0 1 0 0
 * <p>
 * The sequence takes its name from the fact that it represents the sequence
 * of left and right folds along a strip of paper that is folded repeatedly in
 * half in the same direction. If each fold is then opened out to create a
 * right-angled corner, then the results shape approaches the dragon curve
 * fractal.
 * <p>
 * Your challenge today is to implement a regular paperfold sequence generator
 * up to 8 cycles (it gets lengthy quickly).
 */
class Challenge359 {

    private static final String SEQUENCE_START = "1";

    private boolean onOne = true;

    String generate(int steps) {
        String sequence = SEQUENCE_START;
        for (int i = 0; i < steps; i++) {
            for (int j = 0; j < sequence.length(); j += 2) {
                sequence = sequence.substring(0, j) + getNext() + sequence.substring(j);
            }
            sequence += getNext();
        }
        return sequence;
    }

    private char getNext() {
        return ((onOne = !onOne) ? '0' : '1');
    }

}
