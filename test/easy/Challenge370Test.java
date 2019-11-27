package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge370Test {

    private Challenge370 challenge370;
    private HashMap<Integer, String> map;

    @Before
    public void setUp() throws Exception {
        challenge370 = new Challenge370();

        map = new HashMap<>();
        map.put(4, "4210000526");
        map.put(2, "3600029145");
        map.put(0, "1234567");
    }

    @Test
    public void testStandard() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            assertEquals((int) entry.getKey(), challenge370.calculateUpc(entry.getValue()));
        }
    }
}
