package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge375Test {

    private Challenge375 challenge375;
    private HashMap<Long, Long> map;

    @Before
    public void setUp() throws Exception {
        challenge375 = new Challenge375();

        map = new HashMap<>();
        map.put(10109L, 998L);
    }

    @Test
    public void testStandard() {
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            assertEquals((long) entry.getKey(), challenge375.calculateNewNumber(entry.getValue()));
        }
    }
}
