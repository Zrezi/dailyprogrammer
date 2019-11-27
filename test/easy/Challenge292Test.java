package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge292Test {

    private Challenge292 challenge292;
    private HashMap<String, String> standardMap;

    @Before
    public void setUp() throws Exception {
        challenge292 = new Challenge292();

        setUpStandardMap();
    }

    private void setUpStandardMap() {
        standardMap = new HashMap<>();
        standardMap.put("1,3,7,2,4,1", "1 3 7 12 14 21");
//        standardMap.put("1-3,1-2", "1 2 3 11 12");
//        standardMap.put("1:5:2", "1 3 5");
//        standardMap.put("104-2", "104 105 106 107 108 109 110 111 112");
//        standardMap.put("104..02", "It's eight twenty nine pm");
//        standardMap.put("21:00", "It's nine pm");
    }

    @Test
    public void testStandard() {
        for (Map.Entry<String, String> entry : standardMap.entrySet()) {
            assertEquals(entry.getValue(), challenge292.convertToRealNumbers(entry.getKey()));
        }
    }
}
