package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge369Test {

    private Challenge369 challenge369;
    private HashMap<String, int[]> map;

    @Before
    public void setUp() throws Exception {
        challenge369 = new Challenge369();

        map = new HashMap<>();
        map.put("#FF6347", new int[] { 255,  99,  71 });
        map.put("#B8860B", new int[] { 184, 134,  11 });
        map.put("#BDB76B", new int[] { 189, 183, 107 });
        map.put("#0000CD", new int[] {   0,   0, 205 });
    }

    @Test
    public void testStandard() {
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            assertEquals(entry.getKey(), challenge369.rgbToHexadecimal(arr[0], arr[1], arr[2]));
        }
    }
}
