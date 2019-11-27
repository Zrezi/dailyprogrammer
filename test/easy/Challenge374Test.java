package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge374Test {

    private Challenge374 challenge374;
    private HashMap<Long, Long> map;

    @Before
    public void setUp() throws Exception {
        challenge374 = new Challenge374();

        map = new HashMap<>();
        map.put(1L, 13L);
        map.put(2L, 1234L);
        map.put(3L, 199L);
    }

    @Test
    public void testStandard() {
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            assertEquals((long) entry.getKey(), challenge374.calculateAdditivePersistence(entry.getValue()));
        }
    }
}
