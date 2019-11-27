package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge3Test {

    private Challenge3 challenge3;
    private HashMap<String, String> standardMap;

    @Before
    public void setUp() throws Exception {
        challenge3 = new Challenge3();

        setUpStandardMap();
    }

    private void setUpStandardMap() {
        standardMap = new HashMap<>();
        standardMap.put("kOyat ehn", "Okay then");
        standardMap.put("Okay then", "kOyat ehn");
        standardMap.put("oDsee cnyrtpoi nowkr?", "Does encryption work?");
        standardMap.put("Does encryption work?", "oDsee cnyrtpoi nowkr?");
    }

    @Test
    public void testStandard() {
        for (Map.Entry<String, String> entry : standardMap.entrySet()) {
            assertEquals(entry.getKey(), challenge3.encrypt(entry.getValue()));
        }
    }
}
