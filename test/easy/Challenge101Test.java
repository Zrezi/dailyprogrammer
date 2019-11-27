package easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Challenge101Test {

    Challenge101 challenge101;

    @Before
    public void setUp() throws Exception {
        challenge101 = new Challenge101();
    }

    @Test
    public void testStandard() {
        assertEquals(7, challenge101.countYearsWithoutRepeatedDigits(1980, 1989));
    }

    @Test
    public void testGetLongestRunOfYearsWithRepeatingDigits() {
        assertEquals(104, challenge101.getLongestRunOfYearsWithRepeatingDigits().size());
    }

    @Test
    public void testGetLongestRunOfYearsWithNonRepeatingDigits() {
        assertEquals(7, challenge101.getLongestRunOfYearsWithoutRepeatingDigits().size());
    }
}
